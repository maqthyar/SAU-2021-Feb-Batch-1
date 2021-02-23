package handsOn;
import java.util.*;

public class Replace_1 {

	public static void main(String[] args) 
	{
		
			System.out.println("Enter the string ");
			Scanner sc= new Scanner(System.in);
			
			String s = sc.nextLine();
			System.out.println("Enter the reg ex to be replaced");
			
			String reg = sc.nextLine();
			
			System.out.println("Enter the replacing string");
			String rep = sc.nextLine();
			
			
			String newRep = s.replaceAll(reg,rep);
			
			System.out.println("Replace string is "+newRep);
			
	}

}
