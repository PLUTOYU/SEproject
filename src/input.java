
import java.util.Scanner;
public class input{
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		System.out.print("You could record mood here:");
		String s = input.nextLine();
		System.out.println("your moode is" +"\t"+ s );
	    input.close(); 
	}
}