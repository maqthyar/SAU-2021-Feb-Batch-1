package handsOn;

class MyCustomException extends RuntimeException 
{

    public MyCustomException(String message) 
    {
        super(message);
    }

}

public class Exception_3 {

	static boolean isPrime(int x)
	{
		if(x == 1) return false;
		
		for(int i=2;i<=(x/2);i++)
		{
			if((x%i) == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try {
			for(int i = 1;i<=100;i++)
			{
				System.out.println("Counter value "+i);
				if(isPrime(i))
					throw new MyCustomException("Prime number "+i+" encountered");
			}
		}
		catch (MyCustomException e){
			System.out.println(e);
		}
		
	}

}
