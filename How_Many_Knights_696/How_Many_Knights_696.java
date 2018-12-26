import java.io.BufferedReader;
import java.io.InputStreamReader;

public class How_Many_Knights_696 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			
			while(!inp.equals("0 0"))
			{
				String[] inps = inp.split(" ");
				//int[] x = new int[2];
				int x = Integer.parseInt(inps[0]);
				int y = Integer.parseInt(inps[1]);
				int res = 0;
				if(x > y)
				{
					x = x+y;
					y = x-y;
					x = x-y;
				}
				if(x==1)
					System.out.println(y + " knights may be placed on a "+x+" row "+y+" column board.");
				if(x==2)
				{
					 res = y / 4 * 4 + (y % 4 == 1? 2 : (y % 4 >= 2? 4 : 0));
						System.out.println(res + " knights may be placed on a "+x+" row "+y+" column board.");
				}
					
				else
					System.out.println(((x*y)+1)/2 + " knights may be placed on a "+x+" row "+y+" column board.");
			inp = in.readLine();
			}
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		}

}
