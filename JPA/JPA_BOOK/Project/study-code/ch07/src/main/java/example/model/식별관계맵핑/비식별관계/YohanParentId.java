package example.model.식별관계맵핑.비식별관계;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class YohanParentId implements Serializable {

    @Column(name = "PARENT_ID1")
    private String id1;

    @Column(name = "PARENT_ID2")
    private String id2;

    public YohanParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
