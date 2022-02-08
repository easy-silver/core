package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때마다 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 생성
        MemberService memberService2 = appConfig.memberService();

        //참조 값이 다른 것을 확인
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 사용한 객체 사용")
    void SingletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //isSameAs: == 비교
        //isEqualTo: equals
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
