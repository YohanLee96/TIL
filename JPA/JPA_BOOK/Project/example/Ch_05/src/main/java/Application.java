import model.*;

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
        try {
            transaction.begin();

            ShopMember shopMember = ShopMember.builder()
                    .id(1L)
                    .name("이요한")
                    .city("수원시")
                    .street("수원로")
                    .zipCode("345-2")
                    .build();
            Item item = Item.builder()
                    .id(1L)
                    .name("텀블러")
                    .price(43000)
                    .stockQuantity(34)
                    .build();
            Order order = Order.builder()
                    .id(1L)
                    .shopMember(shopMember)
                    .orderDate(new Date())
                    .orderStatus(OrderStatus.ORDER)
                    .build();
            OrderItem orderItem  = OrderItem.builder()
                    .id(1L)
                    .item(item)
                    .count(2)
                    .orderPrice(53000)
                    .order(order)
                    .build();

            manager.persist(shopMember);
            manager.persist(item);
            manager.persist(order);
            manager.persist(orderItem);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

        //조회
        getShopMemberAsOrder(manager);
        getItemAsOrderItemAsOrder(manager);

        manager.close();
        factory.close();

    }

    public static void getShopMemberAsOrder(EntityManager manager) {
        Order order = manager.find(Order.class, 1L);
        ShopMember member = order.getShopMember();

        System.out.println("회원의 이름 : " + member.getName());
    }

    public static void getItemAsOrderItemAsOrder(EntityManager manager) {
        Order order = manager.find(Order.class, 1L);
        if(!order.getOrderItems().isEmpty()) {
            OrderItem orderItem = order.getOrderItems().get(0);
            Item item = orderItem.getItem();
            System.out.println("상품의 이름 : " + item.getName());
        }
    }
}
