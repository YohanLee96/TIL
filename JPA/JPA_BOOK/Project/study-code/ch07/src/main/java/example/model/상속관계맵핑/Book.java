package example.model.상속관계맵핑;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") //엔티티 저장 컬럼값을 커스텀하게 사용할때 이용.
public class Book extends Item {


    private String author;

    private String isbn;
}
