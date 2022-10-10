package springbook.user.domain.Dao;

import springbook.user.domain.ConnectionMaker.ConnectionMaker;
import springbook.user.domain.Dto.Coin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinDao {

    private ConnectionMaker connectionMaker;

    public CoinDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }


    public void add(Coin coin) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO coin(coinNo,coinCnt) values (?,?)");
        statement.setString(1,coin.getCoinNo());
        statement.setInt(2,coin.getCoinCnt());

        statement.execute();

        System.out.println("등록완료.");
    }

    public Coin get(String coinId) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT  * FROM coin WHERE coinNo = ?");
        statement.setString(1, coinId);
        ResultSet  resultSet = statement.executeQuery();
        resultSet.next();
        Coin coin = new Coin();
        coin.setCoinNo(resultSet.getString("coinNo"));
        coin.setCoinCnt(resultSet.getInt("coinCnt"));


        return coin;
    }

    public void truncate() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement statement =connection.prepareStatement("TRUNCATE TABLE coin");
        statement.execute();
    }

}
