package handsOn;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Keys_2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements in map");
		int n = sc.nextInt();
		
		HashMap<String, String> mp = new HashMap<String,String>();
		
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter key ");
			String k = sc.nextLine();
			System.out.println("Enter value for "+k);
			String v = sc.nextLine();
			
			mp.put(k, v);
			
		}
		
		Stack<String> s = new Stack<String>();
		
		System.out.println("Orginal TreeMap content: " + mp);
		mp.forEach((k,v) -> s.push(k));
		
		System.out.println("Reversed keys are ");
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
	}

}
