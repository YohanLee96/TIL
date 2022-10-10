package com.flux.study.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {
    private Long userNo;
    private String name;
    private String id;

    private List<Customer> customerList;

    @Builder
    public User(Long userNo, String name, String id, List<Customer> customerLust) {
        this.userNo = userNo;
        this.name = name;
        this.id = id;
        this.customerList = customerLust;
    }

}
