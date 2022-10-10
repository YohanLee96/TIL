package model;

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
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private ShopMember shopMember;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public void setMember(ShopMember shopMember) {
        //기존 연관관계 제거.
        if(this.shopMember != null) {
            this.shopMember.getOrders().remove(this);
        }

        this.shopMember = shopMember;
        shopMember.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    @Builder
    public Order(Long id, ShopMember shopMember, List<OrderItem> orderItems, Date orderDate, OrderStatus orderStatus) {
        this.id = id;
        this.shopMember = shopMember;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
}

