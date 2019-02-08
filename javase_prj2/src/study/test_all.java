package study;

public class test_all {

	public static void main(String[] args) {
		
//		int sum=0;
//		for(int i=1; i<101; i++) {
//			sum+=i;
//		}
//		System.out.println(sum);
//	}

	for(int i=2; i<10; i++) {
		for(int j=1; j<10; j++) {
			System.out.println(i+" * "+j+" = "+(i*j));
		}
	}//end for
	
	
	for(int i=0; i<5; i++) {
		for(int j=0; j<i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	
	
	int arr[] =new int[9];
	for(int i=0; i<10; i++) {
		for(int j=0; j<10; j++) {
		System.out.println(arr[j]=i*j);
			}
	}
	
	
	}//main
}
