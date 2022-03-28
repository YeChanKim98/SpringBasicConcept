package Spring_Core.core;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration // 해당 어노테이션은 '컴포넌트' 속성을 가진다.
@ComponentScan(
        // 컴포넌트 스캔의 범위를 지정하면, 해당 범위에서만 스캔을 한다. 미지정시, 모든 파일을 다 확인하므로, 필요한 최소범위를 지정해주도록한다
        // 디폴트 : 현재 설정정보 클래스 파일이 속한 패키지 하위를 전부 탐색한다
        // 권장방법 : 설정정보를 프로젝트의 최상단에 두어, 프로젝트내부만 탐색하여, 필요한 코드를 찾는다
        basePackages = "Spring_Core.core",

        // 자동등록 제외대상 정의 : @Configuration 이 붙은 클래스는 제외. -> 스캔은 설정 파일도 스캔하여 등록한느데, 현재 프로젝트에 수동 설정 파일이 있으므로, 해당 파일이 자동으로 잡히지 않도록 하기 위해서
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    많은 스프링 빈을 등록하기 위해 메소드에 어노테이션을 쓰거나 xml설정파일을 작성하는 것은 시간낭비이다.
//    하지만, 설정 정보 없이 자동으로 빈을 등록하는 '컴포넌트 스캔'과  자동으로 의존관계를 주입해주는 '오토와이어'를 통해서
//    개발을 수월하게 할 수 있다.

//    자동으로 등록된 빈의 이름은 기존 클래스 이름의 앞글자만 소문자로 바꾼 후 등록된다.
//    @Component("지정 이름")의 방법을 통해서 빈에 등록할 이름을 지정할 수도 있다.

//    자동 등록빈과 수동 등록빈의 등록이름이 같을 때, 컴포넌트 스캔을 돌리면 충돌이 나는가?
//    안남. -> 수동 등록빈이 우선권을 가져가서 자동등록빈을 오버라이딩 한다.
//    해당 사항으로인해서 설정이 꼬이면 에러를 잡기 어려우니까, 최근 스프링 부트에서는 충돌시 그냥 튕기게 만들었다. 단, 설정을 통해서 오버라이딩 기능을 킬 수 있다.
}
