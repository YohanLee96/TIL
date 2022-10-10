package example.model.상속관계맵핑.MappedSuperClass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;

/**
 * BaseEntity 클래스에서 상속받은 컬럼을
 * 자식 클래스인 Member 클래스에서 따로 커스텀하게 컬럼을 사용하기 위한 방법
 */
//@Entity
@AttributeOverrides({
        //상속받은 id컬럼 Name을 MEMBER_ID로 바꾼다.
        @AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")),
        //상속받은 name컬럼 Name을 MEMBER_NAME으로 바꾼다.
        @AttributeOverride(name = "name", column = @Column(name = "MEMBER_NAME"))
})
public class Member extends BaseEntity {

    private String email;
}
