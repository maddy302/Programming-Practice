import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SecretReaearch_00621 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			String prev_result = "";
			while(!inp.isEmpty()) 
			{
				long test_cases = Long.parseLong(inp);
				while(test_cases > 0) {
					String exp_result = in.readLine();
					if(exp_result.equals("1") || exp_result.equals("4") || exp_result.equals("78")) // reg ex - 1|4|78
					{
						System.out.println("+");
						prev_result = "+";
					}
					else if(exp_result.substring(exp_result.length()-2, exp_result.length()) .equals("35")) // reg ex - [0-9]+35
					{
						System.out.println("-");
						prev_result = "-";
					}
					else if(exp_result.charAt(0) == '9' && exp_result.charAt(exp_result.length()-1) == '4') // reg ex - 9[0-9]+4
					{
						System.out.println("*");
						prev_result = "*";
					}
					else if(exp_result.length()>3 && exp_result.substring(0, 3).equals("190")) //reg ex - 190[0-9]+
					{
						System.out.println("?");
						prev_result = "?";
					}
						
				test_cases--;
				}
				inp = in.readLine();
			}
		}
		catch(Exception e){
			
		}
	}

}
