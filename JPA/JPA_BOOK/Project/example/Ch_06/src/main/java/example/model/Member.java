package example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "MEMBER")
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String memberId;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "member"
    )
    private List<Orders> orders;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIP_CODE")
    private String zipCode;


    @Builder
    public Member(String memberId, List<Orders> orders, String city, String street, String zipCode) {
        this.memberId = memberId;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
