package Spring_Core.core.scope;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototype {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean pb_1 = ac.getBean(PrototypeBean.class);
        pb_1.addCount();
        System.out.println(pb_1.getCount());
        PrototypeBean pb_2 = ac.getBean(PrototypeBean.class);
        pb_2.addCount();
        System.out.println(pb_2.getCount());

    }

    @Test
    @DisplayName("싱글톤과 프로토의 혼용")
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean cb_1 = ac.getBean(ClientBean.class);
        cb_1.logic();

    }

    @Scope("singleton")
    //@RequiredArgsConstructor
    static class ClientBean{

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;
//        @Autowired
//        스프링 Provider
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

//        private final PrototypeBean prototypeBean;
//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean) {
//            this.prototypeBean = prototypeBean;
//        }

        public int logic(){
            // 해결법1. 해당 위치에서 매번 프로토타입 빈을 새로 생성받는다
            // PrototypeBean prototypeBean =  prototypeBeanProvider.getObject();// 해결법2. 스프링 Provider이용
            PrototypeBean prototypeBean =  prototypeBeanProvider.get(); // 해결법3. 자바 표준 Provider이용
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){count++;}

        public int getCount(){ return count; }

        @PostConstruct
        public void init(){ System.out.println("Prototype Init / "+this); }

        @PreDestroy
        public void destroy(){ System.out.println("Prototype Destroy"); }
    }
}
