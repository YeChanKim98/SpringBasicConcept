package Spring_Core.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 게터 세터를 통해서 외부에서 해당 클래스 타입의 객체를 생성시, 자동으로 개터,세터를 지원한다
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok hl = new HelloLombok();

    }
}
