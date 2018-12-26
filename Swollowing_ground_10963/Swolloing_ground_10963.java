import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Swolloing_ground_10963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int case_nos = Integer.parseInt(in.readLine());
			ArrayList<String> output = new ArrayList<String>();
			while(case_nos>0) {
				in.readLine();
				int block_nos = Integer.parseInt(in.readLine());
				int temp_block_nos = block_nos;
				int diff =0;
				boolean temp = true;
				while(block_nos > 0)
				{
					String[] block_cord = in.readLine().split(" ");
					int row_top = Integer.parseInt(block_cord[0]);
					int row_bot = Integer.parseInt(block_cord[1]);
					
					if(temp_block_nos == block_nos)
						diff = row_top - row_bot;
					
					if((row_top - row_bot)!=diff)
					{
						temp = false;
						//System.out.println("no");
//						System.out.println("");
						//output.add("no");
					//	break;
					}
					block_nos--;
					
				}
				if(temp)
				{
					System.out.println("yes");
//					System.out.println("");
					//output.add("yes");
				}
				if(!temp) {
					System.out.println("no");
				}
				
				if(case_nos>0)
					System.out.println("");
				case_nos--;
				//System.out.println("");
			}
//			for(int i=0;i<output.size();i++) {
//				System.out.println(output.get(i));
//				if(i!=output.size()-1)
//				System.out.println("");
//			}
		}
		

		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
