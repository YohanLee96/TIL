package example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "DELIVERY")
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    //order.delivery가 연관관계의 주인이니,  mappedBy해준다.
    @OneToOne(mappedBy = "delivery")
    private Orders order;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public void setOrders(Orders order) {
        this.order = order;
    }

    @Builder
    public Delivery(Orders order, String city, String street, String zipCode, DeliveryStatus status) {
        this.order = order;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.status = status;
    }

    public Delivery(Member member) {
        this.status = DeliveryStatus.READY;
        this.city = member.getCity();
        this.street = member.getStreet();
        this.zipCode = member.getZipCode();
    }

}
