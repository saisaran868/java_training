package java_tranning;

public class StringBufferBuilder {
	public static void main(String[]args) {
		StringBuffer message = new StringBuffer("Hello");
		
		message.append(" Java");
		System.out.println(message);
		message.insert(5," World");
		System.out.println(message);
		message.replace(6,11,"Core");
		System.out.println(message);
		message.delete(5,10);
		System.out.println(message);
		message.reverse();
		System.out.println(message);

		   
        StringBuilder newMessage = new StringBuilder("Hello");
        newMessage.append(" World!");
 	   System.out.println();
 	   System.out.println(newMessage);



		   

	}

}
