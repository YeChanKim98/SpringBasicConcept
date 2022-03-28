package Spring_Core.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean sb_1 = ac.getBean(SingletonBean.class);
        SingletonBean sb_2 = ac.getBean(SingletonBean.class);
        System.out.println("sb_1 = " + sb_1);
        System.out.println("sb_2 = " + sb_2);
        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean{

        @PostConstruct
        public void init(){
            System.out.println("SingletonBean Initialize");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean Destroy");
        }
    }
}
