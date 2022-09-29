package com.basic.core.singleton;

public class StatefulServiceChange {

//    private int price; //상태 유지하는 필드

    //지역변수,파라미터, ThreadLocal등을 사용하여 문제점 개선 가능. 그래서 위의 코드는 필요X

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제 !
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
