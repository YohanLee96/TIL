package example;

import example.model.식별관계맵핑.비식별관계.Child;
import example.model.식별관계맵핑.비식별관계.Parent;
import example.model.식별관계맵핑.비식별관계.YohanParent;
import example.model.식별관계맵핑.비식별관계.YohanParentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("study");
    private static final EntityManager manager = factory.createEntityManager();
    private static final EntityTransaction transaction = manager.getTransaction();

    public static void main(String[] args) {
        //Idclass_identification_relation();
        //EmbeddedId_identification_relation();
        try {
            transaction.begin();


            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public static void Idclass_identification_relation() {
        Parent parent = new Parent();
        parent.setId1("myId1");
        parent.setId2("myId2");
        parent.setName("parentName");

        Child child = new Child(parent);

        manager.persist(child);
        manager.persist(parent);
    }

    public static void EmbeddedId_identification_relation() {
        YohanParent parent = new YohanParent();
        YohanParentId parentId = new YohanParentId("myId1", "myId2");
    }



}
