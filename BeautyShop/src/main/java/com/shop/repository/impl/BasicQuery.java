package com.shop.repository.impl;

import com.shop.common.annotation.Id;
import com.shop.paging.Pageable;
import com.shop.repository.JpaRepository;
import com.shop.repository.UserRepository;
import com.shop.util.AnnotationUtil;
import com.shop.util.MySqlConnectionUtil;
import com.shop.util.ObjectUtil;
import com.shop.util.pool.ConnectionPool;
import com.shop.util.pool.ConnectionPoolImpl;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BasicQuery<T, ID extends Serializable> implements JpaRepository<T, ID> {
    protected ConnectionPool<Connection> connectionPool;
    protected Class<T> tClass;

    public BasicQuery() {
        connectionPool = new MySqlConnectionUtil();
        tClass = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public <S extends T> S insert(T entity) throws SQLException {
        StringBuilder sql = new StringBuilder(Query.INSERT);
        sql.append(AnnotationUtil.getTableName(tClass)).append("(");
        Field[] fields = entity.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            try {
                if (field.isAnnotationPresent(Id.class)) {
                    sql.append(AnnotationUtil.getPrimarykey(tClass, field.getName())).append(",");
                } else {
                    sql.append(AnnotationUtil.getFields(tClass, field.getName())).append(",");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        });

        sql.deleteCharAt(sql.length() - 1);
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        connection.setAutoCommit(false);
        sql.append(")").append(Query.VALUES).append("(");

        Arrays.stream(fields).forEach(field -> {
            sql.append("?").append(",");
        });

        sql.deleteCharAt(sql.length() - 1).append(")");

        PreparedStatement ps = connection.prepareStatement(sql.toString());

        try {
            for (int i = 0; i < fields.length; i++) {
                ps.setObject(i + 1, ObjectUtil.getMethod(entity, fields[i]));
            }
            ps.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return (S) entity;
    }

    @Override
    public void update(T entity) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.UPDATE)
                .append(AnnotationUtil.getTableName(tClass))
                .append(Query.SET);
        Field[] fields = entity.getClass().getDeclaredFields();
        try {
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                sql.append(AnnotationUtil.getFields(tClass, field.getName())).append(" = ?,");
            }
            sql.deleteCharAt(sql.length() - 1).append(" ");
            connection.setAutoCommit(false);
            sql.append(Query.WHERE).append(AnnotationUtil.getPrimarykey(tClass, fields[0].getName())).append(" =?");
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            for (int i = 1; i < fields.length; i++) {
                ps.setObject(i, ObjectUtil.getMethod(entity, fields[i]));
            }
            ps.setObject(fields.length, ObjectUtil.getMethod(entity, fields[0]));
            ps.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public <S extends T> S findById(ID id) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        try {
            StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass)).append(Query.WHERE).append(AnnotationUtil.getPrimarykey(tClass, "id")).append(" =?");
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Object object = null;
            while (resultSet.next()) {
                object = ObjectUtil.map(tClass, resultSet);
            }
            return (S) object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return null;
    }

    @Override
    public long count() {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.COUNT).append(AnnotationUtil.getTableName(tClass));

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            long result = 0;
            while (rs.next()) {
                result = rs.getLong(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return 0;
    }

    @Override
    public long countByCondition(String idMenuCon) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.COUNT).append(AnnotationUtil.getTableName(tClass)).append(" WHERE idMenuCon = ?");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ps.setObject(1, idMenuCon);
            ResultSet rs = ps.executeQuery();
            long result = 0;
            while (rs.next()) {
                result = rs.getLong(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return 0;
    }


    @Override
    public long countById(String name, String conditions) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.COUNT).append(AnnotationUtil.getTableName(tClass)).append(Query.WHERE).append(name).append(Query.LIKE).append("'%" + conditions + "%'");

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            long result = 0;
            while (rs.next()) {
                result = rs.getLong(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return 0;
    }

    @Override
    public void delete(ID id) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        try {
            StringBuilder sql = new StringBuilder(Query.DELETE)
                    .append(AnnotationUtil.getTableName(tClass))
                    .append(Query.WHERE)
                    .append(AnnotationUtil.getPrimarykey(tClass, "id"))
                    .append(" = ?");
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
        } catch (SQLException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public <S extends T> List<S> findByProperties(Map<String, Object> filter) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass)).append(Query.WHERE).append(" 1 = 1");
        for (Map.Entry entry : filter.entrySet()) {
            if (entry.getValue() != null) {
                sql.append(Query.AND).append(" ").append(entry.getKey()).append(" = ?");
            }
        }
        sql.delete(sql.lastIndexOf("AND"), sql.length() - 1);
        try {
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<T> results = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) ObjectUtil.map(tClass, resultSet);
                results.add(t);
            }
            return (List<S>) results;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public <S extends T> List<S> findAll() {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass));
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) ObjectUtil.map(tClass, resultSet);
                list.add(t);

            }
            return (List<S>) list;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public <S extends T> List<S> findByCondition(String condition, String id_user) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass)).append(Query.WHERE).append(condition + " AND id_user = " + id_user + "");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) ObjectUtil.map(tClass, resultSet);
                list.add(t);

            }
            return (List<S>) list;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public <S extends T> List<S> findByCondition(String condition) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass)).append(Query.WHERE).append("id = " + condition + "");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) ObjectUtil.map(tClass, resultSet);
                list.add(t);

            }
            return (List<S>) list;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    @Override
    public void update(T entity, int ID) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.UPDATE)
                .append(AnnotationUtil.getTableName(tClass))
                .append(Query.SET);
        Field[] fields = entity.getClass().getDeclaredFields();
        try {
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                sql.append(AnnotationUtil.getFields(tClass, field.getName())).append(" = ?,");
            }
            sql.deleteCharAt(sql.length() - 1).append(" ");
            connection.setAutoCommit(false);
            sql.append(Query.WHERE).append(AnnotationUtil.getPrimarykey(tClass, fields[0].getName())).append(" =?");
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            for (int i = 1; i < fields.length; i++) {
                ps.setObject(i, ObjectUtil.getMethod(entity, fields[i]));
            }
            ps.setObject(fields.length, ObjectUtil.getMethod(entity, fields[0]));
            ps.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }


    @Override
    public <S extends T> List<S> findAll(Pageable pageable) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT)
                .append(AnnotationUtil.getTableName(tClass))
                .append(Query.LIMIT).append(pageable.getPage())
                .append(Query.OFFSET).append(pageable.getOffset());

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = (T) ObjectUtil.map(tClass, rs);

                list.add(t);
            }

            return (List<S>) list;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Pageable pageable, String sortName, String sortBy, String nameProduct) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT)
                .append(AnnotationUtil.getTableName(tClass));
        if (nameProduct != null && !nameProduct.equals("") && !nameProduct.equals("null")) {
            sql.append(Query.WHERE).append("ten like ").append("'%" + nameProduct + "%'");
        }
        if (sortName != null && sortBy != null && StringUtils.isNotBlank(sortName) && StringUtils.isNotBlank(sortBy) && !sortName.equals("null") && !sortBy.equals("null")) {
            sql.append(Query.ORDER_BY).append(sortName).append(" ").append(sortBy);
        }
        sql.append(Query.LIMIT).append(pageable.getPage())
                .append(Query.OFFSET).append(pageable.getOffset());
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = (T) ObjectUtil.map(tClass, rs);
                list.add(t);
            }

            return (List<S>) list;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Pageable pageable, String sortName, String sortBy, int idMenuCon) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT)
                .append(AnnotationUtil.getTableName(tClass));
        if (idMenuCon > 0) {
            sql.append(Query.WHERE).append(" IdMenuCon = ").append(idMenuCon);
        }
        if (sortName != null && sortBy != null && StringUtils.isNotBlank(sortName) && StringUtils.isNotBlank(sortBy) && !sortName.equals("null") && !sortBy.equals("null")) {
            sql.append(Query.ORDER_BY).append(sortName).append(" ").append(sortBy);
        }
        sql.append(Query.LIMIT).append(pageable.getPage())
                .append(Query.OFFSET).append(pageable.getOffset());
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = (T) ObjectUtil.map(tClass, rs);
                list.add(t);
            }

            return (List<S>) list;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
        return null;
    }

    @Override
    public <S extends T> List<S> findAllById(String name, String idUser, String orderName, String orderBy) {
        Connection connection = ((ConnectionPoolImpl) (connectionPool)).takeOut();
        StringBuilder sql = new StringBuilder(Query.SELECT).append(AnnotationUtil.getTableName(tClass));
        if (!name.equals("null") && !idUser.equals("null") && !idUser.equals("sale")) {
            sql.append(" where " + name + " = " + idUser + " ");
        }
        if (!name.equals("null") && !idUser.equals("null") && idUser.equals("sale")) {
            sql.append(" where " + name + " = '" + idUser + "' ");
        }
        if (!orderName.equals("null") && !orderBy.equals("null") && orderName != null && orderBy != null) {
            sql.append(Query.ORDER_BY).append(" " + orderName + " ").append(" " + orderBy + " ");
        }
        sql.append(" limit 8");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            ResultSet resultSet = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = (T) ObjectUtil.map(tClass, resultSet);
                list.add(t);

            }
            return (List<S>) list;
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            return null;
        } finally {
            ((ConnectionPoolImpl) connectionPool).takeIn(connection);
        }
    }

    public interface Query {
        String SELECT = "SELECT * FROM ";
        String COUNT = "SELECT COUNT(*) FROM ";
        String WHERE = " WHERE ";
        String AND = " AND ";
        String OR = " OR ";
        String LIKE = " LIKE ";
        String INSERT = "INSERT INTO ";
        String UPDATE = "UPDATE ";
        String DELETE = "DELETE FROM ";
        String SET = " SET ";
        String ORDER_BY = " ORDER BY ";
        String VALUES = " VALUES ";
        String LIMIT = " LIMIT ";
        String OFFSET = " OFFSET ";
    }
}
