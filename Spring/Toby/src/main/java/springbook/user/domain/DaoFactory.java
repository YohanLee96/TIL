package springbook.user.domain;

import springbook.user.domain.ConnectionMaker.BlockWareConnectionMaker;
import springbook.user.domain.ConnectionMaker.ConnectionMaker;
import springbook.user.domain.Dao.CoinDao;
import springbook.user.domain.Dao.UserDao;


//ConnectionMaker를 이용한 UserDao생성에 대한 작업을 분리하기위해 만든 팩토리클래스.
public class DaoFactory {


    //User Data Access Object를 생성해서 반환해주기 위한 메소드
   public UserDao blockWareUserDao(){ return new UserDao(blockWareConnection()); }

    //Coin Data Access Object를 생성해서 반환해주기 위한 메소드
    public CoinDao blockWareCoinDao(){ return new CoinDao(blockWareConnection()); }

    //블록웨어 커넥션메이커 공통 메소드
    public ConnectionMaker blockWareConnection(){ return new BlockWareConnectionMaker(); }
}
