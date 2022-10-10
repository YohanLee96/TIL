package example.model.식별관계맵핑.비식별관계;

import java.io.Serializable;

public class ParentId implements Serializable {

    private String id1;
    private String id2;

    public ParentId() {}

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
