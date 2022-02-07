package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 객체를 생성, 연결하는 책임을 갖는 클래스
 */
public class AppConfig {

    public MemberService memberService() {
        //레포지토리 구현체를 MemoryMemberRepository로 지정
        return new MemberServiceImpl(memberRepository());
    }

    //레포지토리의 구현체를 지정한다.
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //할인 정책의 구현체를 지정한다.
    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
