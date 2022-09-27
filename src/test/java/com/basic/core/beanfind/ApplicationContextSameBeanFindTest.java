package com.basic.core.beanfind;

import com.basic.core.AppConfig;
import com.basic.core.member.MemberRepository;
import com.basic.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    //AppConfig에 의존하지 않기 위해 AppConfig 여기서 따로 생성한 뒤 위에 넣어줄 것것
   @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
    void findBeanByTypeDuplicate() {
//       MemberRepository bean = ac.getBean(MemberRepository.class);
       assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
   }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value" + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    //static장점 - 클래스 안에 클래스를 썼다는건 얘는 이 클래스 안에서만 쓰겠다는 것
    @Configuration
    static class SameBeanConfig {


        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
            //이렇게 빈의 이름이 다르고 인스턴스 타입이 같을 수 있음
//           return new MemoryMemberRepository(parameter넣을 수 있음);
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
