package Spring_Core.core.lifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client =  ac.getBean(NetworkClient.class);
        client.connect();
        ac.close(); // ac의 타입을 AnnotationConfigApplicationContext 또는 ConfigurableApplicationContext 로 변경해야 사용가능한 메서드
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean // (initMethod="init", destroyMethod="disconnect")
        public NetworkClient networkClient(){
            // 선 생성 후 의존관계 주입
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://LifeCycle.tset");
            return networkClient;
        }
    }
}
