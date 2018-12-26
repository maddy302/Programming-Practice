import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Reverse_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "-3+2*-5*-54";
		
		reverseExpression(x);
		
	}
	public static void reverseExpression(String x)
	{
		Stack<String> operator = new Stack<String>();
		Stack<String> numbers = new Stack<String>();
		Stack<String> operator1 = new Stack<String>();
		Stack<String> numbers1 = new Stack<String>();
		String[] x_ar = x.split("");
		String prev = "";
		int prev_count = 0;
		for(int i=0; i<x_ar.length; i++)
		{
			String num = "";
			if(isNumberic(x_ar[i])) {
			while(i<x_ar.length && (isNumberic(x_ar[i]) || x_ar[i].equals(".")))
			{
				prev = "num";
				num = num+x_ar[i];
				i++;
				//prev_count = 0;
			}
			numbers1.push(num);
			if(prev_count > 1 && i>1)
			{prev_count = 0;
			
				numbers1.push(operator1.pop()+numbers1.pop());
			}
			//i++;
			}
			if(i<x_ar.length)
			{
				operator1.push(x_ar[i]);
				prev = "op";
				prev_count++;
			}
			
			
			

		}
		//String delimiters = "+,-,/,*";
		//String[] tokens = x.split(delimiters);
		String[] tokens1 = {"1","*","2","+","9","-","23"};
		
		for(String x1 : tokens1)
		{
			if(isNumberic(x1))
			{
				numbers.push(x1);
			}
			else
				operator.push(x1);
		}
		
		StringBuilder res = new StringBuilder();
		while(!operator.isEmpty() || !numbers.isEmpty())
		{
			if(!numbers.isEmpty())
			res.append(numbers.pop());
			if(!operator.isEmpty())
			res.append(operator.pop());
		}
		
		StringBuilder res2 = new StringBuilder();
		while(!operator1.isEmpty() || !numbers1.isEmpty())
		{
			if(!numbers1.isEmpty())
			res2.append(numbers1.pop());
			if(!operator1.isEmpty())
			res2.append(operator1.pop());
		}
		
		System.out.println(res.toString());
		System.out.println(res2.toString());
		
	}
	
	public static boolean isNumberic(String x)
	{
		try {
			int j = Integer.parseInt(x);
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}

}
