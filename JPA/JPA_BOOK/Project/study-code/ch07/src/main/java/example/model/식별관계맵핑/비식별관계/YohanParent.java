package example.model.식별관계맵핑.비식별관계;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//@Entity
public class YohanParent {

    @EmbeddedId
    private YohanParentId id;

    private String name;
}
