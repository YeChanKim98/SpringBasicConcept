package Spring_Core.core.beanfind;
import Spring_Core.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// Junit5부터는 public 설정 필요 없음
public class ACTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig .class);

    @Test
    @DisplayName("All Bean List Print")
    void findAllBean(){
        String[] beanList = ac.getBeanDefinitionNames();
        for (String s : beanList) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + "\tObject = " + bean); // 컨테이너에 등록된 이름과 해당 이름에 매칭된 객체정보를 출력
        }
    }

    @Test
    @DisplayName("Regist Bean List Print")
    // 내가 등록한 빈만 출력
    void findMyBean(){
        String[] beanList = ac.getBeanDefinitionNames();
        for (String s : beanList) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);
            // 모든 빈을 불러온 후 각 빈의 롤값을 확인하여, application일 경우에만 출력
            // ROLE_APPLICATION : 직접 만든 빈
            // ROLE_INFRASTRUCTURE : 스프링에서 내부에서 만든 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("name = " + s + "\tObject = " + bean);
            }
        }
    }
}
