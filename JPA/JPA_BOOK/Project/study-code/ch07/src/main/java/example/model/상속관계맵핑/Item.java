package example.model.상속관계맵핑;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //상속관계 맵핑 전략 지정.
@DiscriminatorColumn(name = "DTYPE") //엔티티 구분값을 저장할 컬럼명
public abstract class Item {


    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

}
