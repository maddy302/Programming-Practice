import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AutomaticAns_11547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String inp = in.readLine();
		
		while(!inp.isEmpty()) 
		{
			int testCases = Integer.parseInt(inp);
			while(testCases>0)
			{
				int inp1 = Integer.parseInt(in.readLine());
				float exprsn = (((((inp1*567)/9)+7492)*235)/47) - 498;
				int exprsnInt = (int) (exprsn/10);
				System.out.println(Math.abs((exprsnInt%10)));
				testCases--;
			}
		}
	}
	catch(Exception e){
		
	}

}
}
