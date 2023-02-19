package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    // psvm 치고 엔터 치면 생성됨..!
    public static void main(String[] args) {
        // 의존성 주입
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // Appconfig class 안에 있는 애들을 Spring이 다 만들어서 SpringContainer에 등록해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // getBean(이름, 타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // new Member(~~) 해놓고 opt+cmd+v
        Member newMember = new Member(1L, "memberA", Grade.VIP);
        memberService.join(newMember);

        Member findMember = memberService.findMember(1L);

        //soutv
        System.out.println("newMember = " + newMember);
        System.out.println("findMember = " + findMember);
    }
}
