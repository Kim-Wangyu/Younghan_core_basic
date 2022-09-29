package com.basic.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceChangeTest {


    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulServiceChange statefulService1 = ac.getBean(StatefulServiceChange.class);
        StatefulServiceChange statefulService2 = ac.getBean(StatefulServiceChange.class);

        //이처럼 int userAPrice로 지역변수로 바꾸어 준다.

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice(); 필요 X

        System.out.println("price = " + userAPrice);
        //1이 주문하고 1을 조회했는데 20000원이 나옴. 같은 인스턴스이기 때문
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }


    static  class TestConfig{

        @Bean
        public StatefulServiceChange statefulService(){
            return new StatefulServiceChange();
        }
    }
}