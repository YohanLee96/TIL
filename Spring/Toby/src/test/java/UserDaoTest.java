
import springbook.user.domain.Dao.UserDao;
import springbook.user.domain.DaoFactory;
import springbook.user.domain.Dto.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        DaoFactory daoFactory = new DaoFactory();   //Dao팩토리 생성.

        UserDao userDao = daoFactory.blockWareUserDao();    //Dao팩토리에서 블록웨어UserDao에 대한 메소드 호출.

        userDao.truncate();

        User user = new User();
        user.setId("johnxx1");
        user.setName("이요한");
        user.setPassword("1234");
        userDao.add(user);

        User getUser= userDao.get(user.getId());
        System.out.println("조회한 회원의 이름-> " + getUser.getName());
    }
}
