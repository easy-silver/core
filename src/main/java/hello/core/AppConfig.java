package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

/**
 * 객체를 생성, 연결하는 책임을 갖는 클래스
 */
public class AppConfig {

    /**
     * 의존성 주입(DI)
     */
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

}
