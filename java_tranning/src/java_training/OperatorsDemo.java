package java_tranning;

public class OperatorsDemo {
   public static void main(String[] args) {
	   int a = 10 , b = 5;
	   
	   //1.Arithmetic operators	   
	   System.out.println(a+b);
	   System.out.println(a-b);
	   System.out.println(a*b);
	   System.out.println(a/b);
	   System.out.println(a%b);
	   
	   //2.Assignment operators	   
	   a +=10;
	   a -=5;
	   a *=2;
	   a /=3;
	   a %=4;
	   System.out.println(a);
	   
	   //3.Relational operators
	   System.out.println(a >b);
	   System.out.println(a <b);
	   System.out.println(a>=b);
	   System.out.println(a<=b);
	   System.out.println(a ==b);
	   System.out.println(a !=b);
	   
	   //4.Logical operators
	   System.out.println(a>0 && b>0);
	   System.out.println(a>0 || b>0);
	   System.out.println(!(a>0));
	   
	   //5.Ternary operators
	   int marks = 75;
	   String results = marks>=35 ? "Pass" : "Fail";
	   System.out.println(results);
	   
	   //6.Unary operators
	   int x = 5;
	   System.out.println(++x); //Pre-increment
	   System.out.println(x++); //Post-increment
	   System.out.println(--x); 
	   System.out.println(x--);
	   System.out.println(x);

	   //Combine
      int c =10 , d = 3;
      int total = c+d *2;
      total +=4;
      c++;
      boolean valid = (c>d) && (total >=20);
      String result = valid ?"Pass":"Fail";
 
	   System.out.println("Total "+total);
	   System.out.println("Result "+result);






   }
}
