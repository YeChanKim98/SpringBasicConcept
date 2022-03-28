package Spring_Core.core.SIngleton;

public class StatefulService {
    // 각 트랜잭션은 처음부터 실행되어야한다.
    // 하지만 해당 클래스는 이전 주문에 쓰인 price값이 남아있다.
    // 따라서 price값을 변수로 남기지 말고 바로 반환하도록 하여, 해당 클래스는 가진 state(상태)가 없도록 하는 것이 좋다.
    private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + "Price = " + price);
        return price;
    }

//    public int getPrice(){
//        return price;
//    }

}
