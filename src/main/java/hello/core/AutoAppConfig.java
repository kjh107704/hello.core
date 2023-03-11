package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// Spring 설정 정보이다
@Configuration
// 알아서 Bean을 자동으로 등록해줘라
// @Component annotation이 붙은 애들을 자동으로 다 등록해줌
@ComponentScan (
        // AppConfig에 @Configuration 등록이 되어있는데, @Configuration 내에 @Component가 붙어있음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
