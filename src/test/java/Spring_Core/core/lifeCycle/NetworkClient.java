package Spring_Core.core.lifeCycle;

/*
 [ 1. 인터페이스 상속을 이용한 콜백 구현 ]
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
public class NetworkClient implements InitializingBean, DisposableBean { // 두 인터페이스를 상속 받아서 시작, 종료 콜백을 구현

    private String url;

    public NetworkClient(){ System.out.println("생성자 호출 / URL = " + url); }

    public void setUrl(String url) { this.url = url; }

    public void connect(){ System.out.println("Connect : "+url); }

    public void call(String msg){ System.out.println("call : " + url + "  /  msg = " + msg); }

    public void disconnect(){System.out.println("Close : " + url); }

    @Override
    // 의존관계 주입 후 동작을 지정하는 메서드
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    // 종료시 동작을 지정하는 메서드
    public void destroy() throws Exception {
        disconnect();
    }
}
*/

/*
// [ 2. 빈 등록을 이용한 콜백 구현 ]

public class NetworkClient {

    private String url;

    public NetworkClient(){ System.out.println("생성자 호출 / URL = " + url); }

    public void setUrl(String url){ this.url = url; }

    public void connect(){ System.out.println("Connect : "+url); }

    public void call(String msg){ System.out.println("call : " + url + "  /  msg = " + msg); }

    public void init(){ connect(); call("초기화 콜 메시지"); }

    public void disconnect(){ System.out.println("Close(disconnect) : " + url); }
    
    public void close(){ System.out.println("Close(close) : " + url); } // destroyMethod의 기본값을 통해서 자동실행 가능
}
*/

//  [ 3. 빈으로 등록될 메서드에 초기, 종료 어노테이션 기술 ]
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class NetworkClient {

    private String url;

    public NetworkClient(){ System.out.println("생성자 호출 / URL = " + url); }

    public void setUrl(String url) { this.url = url; }

    public void connect(){ System.out.println("Connect : "+url); }

    public void call(String msg){ System.out.println("call : " + url + "  /  msg = " + msg); }

    @PostConstruct
    public void init(){ connect(); call("초기화 콜 메시지"); }

    @PreDestroy
    public void disconnect(){ System.out.println("Close : " + url); }
}