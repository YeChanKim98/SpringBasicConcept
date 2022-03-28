package Spring_Core.core.web;

import Spring_Core.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    // private final ObjectProvider<MyLogger> myLoggerPro; // 방안-1
    // 따로 생성이 되더라도 같은 HTTP리퀘스트일 경우, 스프링 컨테이너가 같은 빈이 반환됨

    public void logic(String id){
        // MyLogger myLogger = myLoggerPro.getObject(); // 방안-1
        myLogger.log("Service_ID = "+id);
    }
}
