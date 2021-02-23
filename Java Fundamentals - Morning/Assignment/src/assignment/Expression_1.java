package assignment;

import java.util.Stack;

public class Expression_1
{
	
	
	
	public static String simplify(String exp)
	{
		char [] arr= exp.toCharArray();
		for(int i=0;i<exp.length();i++)
		{
			
			if(((i == 0) && (arr[i] == '-') ) || ( arr[i] == '-'  ) )
			{
				int j = i;
				while(j>0 && (arr[j-1] == ' '))
						j--;
				
				if(j == 0 ||  (arr[j-1] < '0' || arr[j-1] > '9'  ))
					arr[i] = '$';
			}
		}
		
		
		
		return new String(arr);
	}
	
	public static boolean haspre(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
		return false;
		if ((op1 == '*' || op1 == '%' || op1 == '/') && 
		(op2 == '-' || op2 == '+'))
		return false;
		else
		return true;
	}

	public static int evaluate(String expression)
	{
		
		char[] arr = simplify(expression).toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == '$')
			{
				System.out.print("(-1)*");
				continue;
			}
			System.out.print(arr[i]);
		}
		System.out.println();
		Stack<Integer> val = new
							Stack<Integer>();

		Stack<Character> ops = new
							Stack<Character>();

		for (int i = 0; i < arr.length; i++)
		{
			

			if (arr[i] == ' ')
				continue;


			if ((arr[i] >= '0' && arr[i] <= '9') || arr[i] == '$')
			{
				
			
				
				StringBuffer sbuf = new StringBuffer();
				
				if(arr[i] == '$')
					{
						val.push(-1 * (arr[i+1]-'0') );
						i++;
						continue;
					}

				while (i < arr.length && arr[i] >= '0' && arr[i] <= '9')
					sbuf.append(arr[i++]);
				val.push(Integer.parseInt(sbuf.toString()));
			
				i--;
			}


			else if (arr[i] == '(') 
				ops.push(arr[i]);

			else if (arr[i] == ')')
			{
				while (ops.peek() != '(')
				val.push(calc(ops.pop(), val.pop(), val.pop()));
				ops.pop();
			}

			else if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/' || arr[i] =='%')
			{
				while (!ops.empty() && haspre(arr[i], ops.peek()))
					val.push(calc(ops.pop(), val.pop(),val.pop()));

				ops.push(arr[i]);
			}
		}

		while (!ops.empty())
			val.push(calc(ops.pop(), val.pop(), val.pop()));


		return val.pop();
	}
	
	public static int calc(char op, int a, int b)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return b - a;
		case '*':
			return a * b;
          case '%':
            return b % a;
		case '/':
			if (a == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return b / a;
		}
		return 0;
	}

	public static void main(String[] args)
	{
		System.out.println(Expression_1.evaluate("5 + 15 / 3 * 2 - 8 % 3"));
		System.out.println(Expression_1.evaluate("(55+9) % 9"));
		System.out.println(Expression_1.evaluate("20 + -3*5 / 8 "));
		System.out.println(Expression_1.evaluate("-5 + 8 * 6"));
	}
}
