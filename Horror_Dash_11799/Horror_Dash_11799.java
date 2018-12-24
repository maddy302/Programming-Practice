import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Horror_Dash_11799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int nos_case = Integer.parseInt(in.readLine());
			int temp = 1;
			while(nos_case > 0) 
			{
				String[] speeds = in.readLine().split(" ");
				System.out.println("Case "+temp+": "+findMax(speeds));
				nos_case--;
				temp++;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static int findMax(String[] speeds) 
	{
		int max = -999999;
		
		for(int i=0; i<speeds.length; i++)
		{
			if(Integer.parseInt(speeds[i]) > max)
				max = Integer.parseInt(speeds[i]);
		}
		
		return max;
	}

}
