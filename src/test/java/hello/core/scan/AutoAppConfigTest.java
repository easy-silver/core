package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        //빈 이름은 구현체 클래스의 앞글자만 소문자로 바꿔준 형태
        //MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
