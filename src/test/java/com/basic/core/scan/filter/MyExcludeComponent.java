package com.basic.core.scan.filter;

import java.lang.annotation.*;


//얘가 붙은건 ComponentScan에 추가할거야 라는  것
@Target(ElementType.TYPE) //TYPE이면 클래스에
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
