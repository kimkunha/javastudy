package day0103;
//19.01.03 -1번 자료- (람다식)
//@FunctionalInterface : JDK 1.8에서 부터 제공. 인터페이스의 추상 method가 하나인지 체크.
//FunctionallInterface는 추상메소드가 무조건 하나이여만 한다.
@FunctionalInterface // Lambda식으로 편하게 사용할 수 있다.
public interface TestLambda {
	public abstract String toDay();
}//interface
