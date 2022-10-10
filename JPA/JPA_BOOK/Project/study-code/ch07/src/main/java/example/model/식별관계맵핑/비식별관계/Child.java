package example.model.식별관계맵핑.비식별관계;

import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 식별자가 2개이므로 조인할 부모테이블의 컬럼을 지정해준다.
     * * @JoinColumn과  referencedColumnName의 name값이 같으면 생략해도 된다.
     */
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1",
                    /**
                     * referencedColumnName
                     *  조인대상인 부모테이블의 컬럼(Parent객체의 식별자 명칭) 명시
                    */
                    referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2",
                    referencedColumnName = "PARENT_ID2"
            )
    })
    private Parent parent;


    public Child(Parent parent) {
        this.parent = parent;
    }
}
