package springbook.user.domain.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BlockWareConnectionMaker implements ConnectionMaker{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost/spring_study", "postgres", "xx0805xx");
    }
}
