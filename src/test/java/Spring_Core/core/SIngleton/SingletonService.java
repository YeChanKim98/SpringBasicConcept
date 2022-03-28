package Spring_Core.core.SIngleton;

public class SingletonService {

    // 내부 매서드들만 이용(접근)할 수 있고(Private), 정정을 해서는 않되며(final), 여럿이서 공유하기 위해서(static)
    // static이기에 초기화 과정없이 바로 접근할 수 있으며, 이는 추후 객체생성이 불필요함을 의미한다 : static memory에 올라간 후 종료 후 내려간다
    private static final SingletonService instance = new SingletonService(); // -> 하나의 객체만 생성하기 위함

    public static SingletonService getInstance(){
        return instance;
    } // 공유를 위한 SingletonService의 게터

    public void logic(){System.out.println("Singleton");}
}
