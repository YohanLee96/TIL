package springbook.user.domain.Dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import springbook.user.domain.ConnectionMaker.BlockWareConnectionMaker;
import springbook.user.domain.ConnectionMaker.ConnectionMaker;
import springbook.user.domain.Dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {


    private  ConnectionMaker connectionMaker;

    public  UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }



    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users(id,name,password) values (?,?,?)");
        statement.setString(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPassword());
        statement.executeUpdate();
        System.out.println("등록 성공");


    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }

    public void truncate() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement =connection.prepareStatement("TRUNCATE TABLE users");
        statement.execute();
    }

}
