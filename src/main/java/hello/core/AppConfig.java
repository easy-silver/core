package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 객체를 생성, 연결하는 책임을 갖는 클래스
 */
public class AppConfig {

    /**
     * 의존 관계 주입(DI)
     */
    public MemberService memberService() {
        //레포지토리 구현체를 MemoryMemberRepository로 지정
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        //서비스에서 사용할 레포지토리와 할인 정책의 구현체를 지정한다.
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
