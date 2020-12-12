package chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/25 11:18 下午
 */

// 使用 ThreadLocal 保证线程的封闭性
// ConnectionDispenser.java
public class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    // 将当前数据库的链接地址生成的 Connection 存入 ThreadLocal，当需要使用时 调用 getConnection() 获取这个连接
    private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection", e);
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
