package example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "order"
    )
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void setMember(Member member) {
        if(this.member != null) {
            //기존에 맺어있는  주문 -> 회원 연관관계가 있다면 제거.
            this.member.getOrders().remove(this);
        }

        this.member = member;
    }

    public void addItem(OrderItem orderItem) {
        if(!this.orderItems.contains(orderItem)) { //무한루프 방지
            /**
             * 양방향 연관관계이므로 현재의 엔티티에도 추가해주고
             * 연과너관계의 주인인 OrderItem 엔티티에도 setter 해준다.
             */
            this.orderItems.add(orderItem);
            orderItem.setOrder(this);
        }
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        this.delivery.setOrders(this);
    }

    @Builder
    public Orders(Member member, Date orderDate, OrderStatus orderStatus) {
        this.member = member;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
}
