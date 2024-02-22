package com.basic.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan( //스프링 빈을 쫙 끌고와서  자동으로 스프링 빈을 끌어올려야된다. ->@Component가 붙은 클래스애들을 다 자동으로 스프링빈 등록해줌
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)//컴포넨트에는 이미 configuration이 중복
)
public class AutoAppConfig {


}
