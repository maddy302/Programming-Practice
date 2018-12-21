import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Summing_Digits_Reccursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			
			while(!inp.equals("0"))
			{
				int sum = 0;
				System.out.println(calculateSum(inp,sum));
				inp = in.readLine();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int calculateSum(String inp, int sum) {
		int k = 0;
		if(inp.length()==1 && (sum+Integer.parseInt(inp))/10==0)
		{
			return sum + Integer.parseInt(inp);
		}
		else if(inp.length() == 1 && (sum+Integer.parseInt(inp))/10!=0)
		{
			return calculateSum( (sum + Integer.parseInt(inp))+"", 0);
		}
		else {
			return calculateSum(inp.substring(0, inp.length()-1),sum+Integer.parseInt(inp.substring(inp.length()-1,inp.length() )));
		}
	}

}
