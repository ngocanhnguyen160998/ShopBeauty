package com.shop.util;

import com.shop.util.pool.ConnectionPoolImpl;

import java.sql.*;
import java.util.ResourceBundle;

public class MySqlConnectionUtil extends ConnectionPoolImpl {
    private static final ResourceBundle rb =ResourceBundle.getBundle("DatabaseInformation");
    private static final String user_name= rb.getString("datasource.user");
    private static final String pass_word = rb.getString("datasource.password");
    private static final String URL=rb.getString("datasource.url");
    private static final String DriverName=rb.getString("datasource.driver");

    @Override
    public Connection create() {
        try {
            Class.forName(DriverName);
            return DriverManager.getConnection(URL,user_name,pass_word);
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public void dead(Connection o) {

    }
    @Override
    public boolean validate(Connection o) {
        return false;
    }

    public void thucThiCauLenhSQL(String sql) throws Exception{
        Connection connect =create();
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
    }
    public ResultSet chonDuLieuTuDTB(String sql) throws Exception{
        Connection connect = create();
        Statement stmt = connect.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        return rs;
    }

}
