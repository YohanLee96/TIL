package com.lannstark.lec06;

import java.util.List;

public class Lec06Main {

    public static void main(String[] args) {
        int i = 1;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }

    }

    void printLong() {
        List<Long> nums = List.of(1L, 2L, 3L);
        for (Long num : nums) {
            System.out.println(num);
        }
    }

    void printOriginFor() {
        for (int i = 1; i < 3; i++) {
            System.out.println(i);
        }
    }

    void printOriginForDown() {
        for (int i = 3; i >= 1 ; i--) {
            System.out.println(i);
        }
    }

    void printOriginForStep() {
        for (int i = 1; i <= 5; i += 2) {
            System.out.println(i);
        }
    }

}
