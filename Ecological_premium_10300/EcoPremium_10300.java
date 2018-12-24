import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EcoPremium_10300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			int test_cases = Integer.parseInt(in.readLine());
			while(test_cases>0)
			{
				int farmer_nos = Integer.parseInt(in.readLine());
				long avg_budget = 0;
				while(farmer_nos > 0) 
				{
					String[] inp = in.readLine().split(" ");
					avg_budget = avg_budget + (Long.parseLong(inp[0])*Long.parseLong(inp[2]));
					farmer_nos--;
				}
				System.out.println(avg_budget);
				test_cases--;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
