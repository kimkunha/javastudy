package Day1115;
/*
		관계연산자 :
		>,		<,		>=		,<=	,==	,!=  관계는 산술보다 연산순위가 떨어지니 괄호를 해야한다
*/
class Operator4 {
	public static void main(String[] args) {
		int i=11, j=15, k=11;
		System.out.println(i+" == "+ k+" = "+( i==k));
		System.out.println(i+" == "+ j+" = "+( i==j));

		System.out.println(i+" !== "+ k+" = "+( i!=k));
		System.out.println(i+" !== "+ k+" = "+( i!=k));
	}
}
