import springbook.user.domain.Dao.CoinDao;
import springbook.user.domain.DaoFactory;
import springbook.user.domain.Dto.Coin;

import java.sql.SQLException;

public class CoinDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DaoFactory daoFactory = new DaoFactory();
        CoinDao coinDao = daoFactory.blockWareCoinDao();

        coinDao.truncate();

        Coin coin = new Coin();

        coin.setCoinNo("1231234");
        coin.setCoinCnt(23748247);

        coinDao.add(coin);

        Coin getCoin = coinDao.get(coin.getCoinNo());
        System.out.println("등록한 Coin의 개수는" + getCoin.getCoinCnt());

    }
}
