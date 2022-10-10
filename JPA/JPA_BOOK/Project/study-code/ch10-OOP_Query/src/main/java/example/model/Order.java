package example.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Yohan lee
 * Created on 2021-01-25.
 **/

@Getter
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

}
