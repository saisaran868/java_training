package java_training;

public class SwapExample {
	public static void main(String[] args) {
		
		//Swap with temporary variable
		int a= 10 , b= 20;
		int temp = a;
		a=b;
		b=temp;
		   System.out.println("a = "+ a);
		   System.out.println("b = "+b);

        //Swap without temporary variable
		int c = 10 , d = 20;
		c= c+d;
		d = c-d;
		c = c-d;
		   System.out.println();

		   System.out.println("c = "+c);
		   System.out.println("d = "+d);

	}

}
