import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

public class Chess_287 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			int testCases = Integer.parseInt(inp);
			
			while(testCases>0)
			{
				String[] input = in.readLine().split(" ");
				int x = Integer.parseInt(input[1]);
				int y = Integer.parseInt(input[2]);
				if(input[0].equals("r"))
					System.out.println(min(x,y));
				
				else if(input[0].equals("Q"))
					System.out.println(min(x,y));
				
				else if(input[0].equals("k"))
					System.out.println(((x*y)+1)/2);
				
				else if(input[0].equals("K"))
					System.out.println(((y+1)/2)*((x+1)/2));
			
				testCases--;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int min(int x, int y)
	{
		
		
		if(x>y)
			return y;
		else
			return x;
	}
}
