package day1129;

/**
 *	HngGilDong은 클래스의 접근 지정자에 final이 없으므로 자식 클래스가 
 *	존재할 수 있지만, Clark은 클래스의 접근 지정자에 final니 존재하므로 자식클래스가 존재 할수 없다.
 *	HongGilDong 은 자신의 기능에 추가하여 다른 기능을 구현할수 있지만,Clark은 자신의 기능만으로 사용하게 된다.
 * @author owner
 */
public class Test extends HongGilDong {   // 홍길동은 final이 아니므로 자식을 가질수 있다.   f(inal부여 안함)
//public class Test extends Clark{  // 접근 지정자에 final이 붙어서 사용불가 상속관계(자식클래스)가 불가능 하다

}
