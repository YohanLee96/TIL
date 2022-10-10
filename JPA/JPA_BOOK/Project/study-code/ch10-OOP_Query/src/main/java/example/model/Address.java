package example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Created by Yohan lee
 * Created on 2021-01-25.
 **/

@Getter
@Setter
@Embeddable
public class Address {

    private String city;

    private String street;

    private String zipCode;


}
