package Spring_Core.core.beanDef;
import Spring_Core.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefTest {
   AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);

   @Test
    @DisplayName("Bean Configuration Meta-Info : Bean Definition")
    void findAppBean(){
       String[] beanDefinitionNames = ac.getBeanDefinitionNames();
       for(String beanDefinitionName : beanDefinitionNames){
           BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
           if(beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION){
               System.out.println("beanDefinitionName = " + beanDefinitionName + "\t beanDefinitionName = " + beanDefinition);
           }
       }
   }
}
