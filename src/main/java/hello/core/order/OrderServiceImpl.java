package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final이 붙은 객체를 가지고 생성자를 알아서 만들어줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    // OrderServiceImpl은 DiscountPolicy 뿐만 아니라 FixDiscountPolicy(구체 클래스)에도 의존함 => DIP 위배
    // 할인정책 변경을 하려면 할인정책의 client인 OrderServiceImpl 소스를 고쳐야 함 => OCP 위배
    // DIP를 위반했으니까, 변경시에 OCP를 위반할 수 밖에 없음
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // DIP를 지키기 위해서는 구체 클래스를 걷어내면 되는데, 이러면 실행이 안됨 => 실행할 때 객체가 할당되지 않으니까
    private final DiscountPolicy rateDiscountPolicy;

    /*
     * lombok의 @RequiredArgsConstructor 로 대체략
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = rateDiscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
