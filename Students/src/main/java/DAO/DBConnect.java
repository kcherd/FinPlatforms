package DAO;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.RunScript;

import java.io.*;
import java.sql.Connection;

/**
 * класс соединения с базой данных
 */
public class DBConnect {
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASS = "";
    private static JdbcConnectionPool connectionPool;

    private DBConnect(){}

    public static void createConnectionPool() {
        if (connectionPool == null) {
            connectionPool = JdbcConnectionPool.create(DB_URL, USER, PASS);
            try {
                initDB();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws Exception {
        return connectionPool.getConnection();
    }

    /**
     * процедура созания и заполнения таблиц базы данных
     */
    private static void initDB() throws Exception{
        //запускаем скрипт создания таблиц
        String schemaResourceName = "./src/main/resources/createTable.sql";
        FileReader fileReader = new FileReader(schemaResourceName);
        RunScript.execute(getConnection(), fileReader);
    }

    /**
     * процедура закрытия пула соединений
     */
    public static void closeConnection(){
        connectionPool.dispose();
    }
}