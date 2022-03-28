package Spring_Core.core.Scan.filter;

import java.lang.annotation.*;

// 임의 어노테이션 정의
@Target(ElementType.TYPE) // 어디에 적용되는지 정의. Type은 Class레벨에 붙는다
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    
}
