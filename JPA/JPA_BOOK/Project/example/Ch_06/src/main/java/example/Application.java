package example;

import example.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Application {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("study");;
    private static final EntityManager manager =  factory.createEntityManager();
    private static final EntityTransaction transaction = manager.getTransaction();

    public static void main(String[] args) {
        //아이템 객체 init
        Item nike = NIKE_PADDING();
        //카테고리 객체 init
        Category wear = WEAR();
        Category padding = PADDING();
        wear.addChildCategory(padding);

        //카테고리, 상품 연결 객체 init
        CategoryItem categoryItem = new CategoryItem(padding, nike);
        Member yohan = MEMBER_YOHAN();

        try {
            transaction.begin();
            //주문을 위한 기초데이터 전처리
            manager.persist(nike);
            manager.persist(wear);
            manager.persist(padding);
            manager.persist(categoryItem);
            manager.persist(yohan);
            //주문 시작
            Orders order = Orders.builder()
                    .member(yohan)
                    .orderStatus(OrderStatus.DELIVER_BEFORE)
                    .orderDate(new Date())
                    .build();

            //배송지 정보 입력.
            Delivery delivery = new Delivery(yohan);

            //주문 상품 등록.
            OrderItem orderItem = OrderItem.builder()
                    .itemId(nike.getId())
                    .count(2)
                    .orderPrice(nike.getPrice() * 2)
                    .build();

            order.setDelivery(delivery);
            order.addItem(orderItem);

            manager.persist(order);
            manager.persist(delivery);
            manager.persist(orderItem);

           transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        confirmOrder(manager);

        manager.close();
        factory.close();

    }

    public static void confirmOrder(EntityManager manager) {
        Orders orders = manager.find(Orders.class, 5L);

        for(OrderItem item : orders.getOrderItems()) {
            Item findItem = manager.find(Item.class, item.getItemId());
            System.out.println("주문한 상품명 : " + findItem.getName());
            System.out.println("주문한 아이템 가격 : " + findItem.getPrice());
        }

    }


    public static Member MEMBER_YOHAN() {
        return Member.builder()
                .memberId("johnxx1")
                .city("수원시")
                .street("964-5 신나무실로")
                .zipCode("223-322")
                .build();
    }

    public static Item NIKE_PADDING() {
        return Item.builder()
                .name("나이키 패딩")
                .price(135000)
                .stockQuantity(23)
                .build();
    }

    public static Category WEAR() {
        return Category.builder()
                .name("옷")
                .build();
    }

    public static Category PADDING() {
        return Category.builder()
                .name("패딩")
                .build();
    }
}
