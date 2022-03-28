package Spring_Core.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean pb_1 = ac.getBean(PrototypeBean.class);
        PrototypeBean pb_2 = ac.getBean(PrototypeBean.class);
        System.out.println("pb_1 = " + pb_1);
        System.out.println("pb_2 = " + pb_2);
        pb_1.destroy();
        pb_2.destroy();
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        public void init(){System.out.println("Prototype Initialize");}

        @PreDestroy
        public void destroy(){System.out.println("Prototype Destroy");}
    }

}
