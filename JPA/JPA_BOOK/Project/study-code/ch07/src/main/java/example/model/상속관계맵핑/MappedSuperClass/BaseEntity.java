package example.model.상속관계맵핑.MappedSuperClass;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 상속관계 맵핑을 위한 추상클래스
 */
@MappedSuperclass //맵핑정보만 상속받는 슈퍼클래스 라는 것을 선언.
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
