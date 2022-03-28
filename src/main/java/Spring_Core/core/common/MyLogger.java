package Spring_Core.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+uuid+"] ["+requestURL+"] ["+message+"]");
    }

    @PostConstruct
    public void init(){
        // uuid생성 함수를 이용한 uuid발급
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] Get Request & Initialize .... "+this);
    }

    @PreDestroy
    public void close(){
        // uuid생성 함수를 이용한 uuid발급
        System.out.println("["+uuid+"] Close Request  .... "+this+"\n");
    }
}
