package io.honeymon.boot.springboot;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class DataJpaExampleTest {
    //테스트 코드
}
