package com.shop.util.pool;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ConnectionPoolImpl implements ConnectionPool<Connection> {
    private long deadTime;
    private Hashtable<Connection, Long> lock;
    private Hashtable<Connection, Long> unlock;
    public ConnectionPoolImpl(){
        deadTime = 10000l;
        lock= new Hashtable<>();
        unlock= new Hashtable<>();
    }
    public synchronized Connection takeOut(){
        long now = System.currentTimeMillis(); //thoi gian hien tai cua he thong
        Connection connection;
        if (unlock.size()>0){
            Enumeration<Connection> enumeration = unlock.keys();
            while (enumeration.hasMoreElements()){
                connection = enumeration.nextElement();
                if((now- unlock.get(connection)) >deadTime){
                    unlock.remove(connection);
                    dead(connection);
                    connection=null;
                }else {
                    if (validate(connection)){
                        unlock.remove(connection);
                        dead(connection);
                        connection =null;
                    }
                }
            }
        }
        connection = create();
        lock.put(connection, now);
        return connection;
    }
    public synchronized void takeIn(Connection connection){
        lock.remove(connection);
        unlock.put(connection, System.currentTimeMillis());
    }

}
