package example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "ORDER_ITEM")
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders order;

    @Column(name = "ITEM_ID")
    private Long itemId;


    @Column(name = "ORDER_PRICE")
    private int orderPrice;

    @Column(name = "COUNT")
    private int count;


    public void setOrder(Orders order) {
        this.order = order;
    }

    @Builder
    public OrderItem(Long itemId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
