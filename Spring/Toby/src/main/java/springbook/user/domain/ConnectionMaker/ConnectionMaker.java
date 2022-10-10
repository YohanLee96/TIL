package springbook.user.domain.ConnectionMaker;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * 커넥션정보는 각 회사마다 다를 수 있다. 고로 구현체로 정의하여 각 사에서 마음껏
 * 커스텀마이징해서 쓸 수 있도록 하자.
 */
public interface ConnectionMaker {


    public Connection getConnection() throws ClassNotFoundException, SQLException;

}
