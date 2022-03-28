package Spring_Core.core.web;

import Spring_Core.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    //private final ObjectProvider<MyLogger>  myLoggerPro; // 방안-1
    // scope 상 리퀘스트발생 후 생성이 되야하므로, 현재 상황에서 웹을 바로 띄우려고하면 오류가 뜬다 -> 따라서, 실제 고객의 요청단계에서 의존성이 주입되어야하므로, look up할 수 있는 프로바이더를 생성

    @RequestMapping("log-demo")
    @ResponseBody // 뷰 없이 문자를 바로 화면에 반환하고 싶을 때, 사용하는 어노테이션
    public String logDemo(HttpServletRequest request) { //HttpServletRequest를 통해서 리퀘스트를 처리할 수 있음
        //MyLogger myLogger = myLoggerPro.getObject(); // 방안-1
        String requestURL = request.getRequestURL().toString(); // 요청 URL 확인
        myLogger.setRequestURL(requestURL);
        myLogger.log("Controller Test");
        logDemoService.logic("Test_ID");
        return "OK";
    }
}
