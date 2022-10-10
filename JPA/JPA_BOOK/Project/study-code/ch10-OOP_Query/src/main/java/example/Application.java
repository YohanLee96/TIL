package example;

import example.model.Member;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Yohan lee
 * Created on 2021-01-25.
 **/
public class Application {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("study");
    private static final EntityManager manager = factory.createEntityManager();
    private static final EntityTransaction transaction = manager.getTransaction();

    public static void main(String[] args) {
        transaction.begin();
        try {
            Member member = new Member();
            member.setName("이요한");
            manager.persist(member);
            TypedQuery<String> typedQuery = manager.createQuery("SELECT m.name FROM Member m WHERE m.name = '이요한'", String.class);

            System.out.println("조회한 이름 :" + typedQuery.getSingleResult());
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public static void jpqlQuery(EntityManager manager) {
        manager.createQuery("" +
                "SELECT " +
                "m " +
                "FROM Member m " +
                "WHERE m.name LIKE '%kim%'", Member.class).getResultList();
    }

    public static void criteriaQuery(EntityManager manager) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> m = query.from(Member.class);

        query.select(m).where(builder.equal(m.get("name"), "kim"));

        manager.createQuery(query).getResultList();
    }

    public static void nativeQuery(EntityManager manager) {
        manager.createNativeQuery("SELECT id FROM MEMBER", Member.class).getResultList();
    }



}
