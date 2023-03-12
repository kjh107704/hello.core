package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    /**
     * 자동 의존관계 주입 옵션 처리 방법
     */
    static class TestBean {

        // 자동주입할 대상이 없으면 이 함수 호출 자체를 안함
        @Autowired(required = false)
        public void setNoBean1(Member nobean1) {
            System.out.println("nobean1 = " + nobean1);
        }

        // 자동주입할 대상이 없으면 이 함수 호출은 하되, null이 들어옴
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // 자동주입할 대상이 없으면 이 함수 호출은 하되, Optional.empty 객체가 들어옴
        @Autowired
        public void setNoBean(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
