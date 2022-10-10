package example.model.상속관계맵핑;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //엔티티를 저장할때 컬럼에 저장할 구분값
public class Album extends Item {
    private String artist;
}
