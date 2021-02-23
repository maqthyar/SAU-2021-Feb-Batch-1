package assignment;

public class Flag_2 {

	public static void main(String[] args) {
		
		String s = "* * * * *";
		for(int i=0;i<10;i++)
		{
			if(i <5 )
			{
				String k = "  ";
				if((i%2) ==1 )
					{
						System.out.print(" ");
						k = " ";
					}
				System.out.print(s+k);
				
			}
			for(int j=0;j<((i<5)?10:21);j++)
				System.out.print("=");
			
			System.out.println();
			
			
		}

	}

}
