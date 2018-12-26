import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sankes_And_Ladder_11459 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int testCases = Integer.parseInt(in.readLine());
			int count = 1;
			
			while(testCases>0)
			{
				HashMap<Long,Integer> player_n_pos = new HashMap<Long,Integer>();
				String[] inp2 = in.readLine().split(" ");
				long players = Long.parseLong(inp2[0]);
				int nos_snake_ladders = Integer.parseInt(inp2[1]);
				int nos_rolls = Integer.parseInt(inp2[2]);
				HashMap<Integer,Integer> snakes_ladders = new HashMap<Integer, Integer>();
				HashMap<Integer,Integer> ladders = new HashMap<Integer,Integer>();
				
				for(long i =1; i<=players;i++)
				{
					player_n_pos.put(i,1);
				}
				//int[] roll = new int[nos_rolls];
				while(nos_snake_ladders>0)
				{
					String[] inp3 = in.readLine().split(" ");
					int x = Integer.parseInt(inp3[0]);
					int y = Integer.parseInt(inp3[1]);
					snakes_ladders.put(x, y);
					nos_snake_ladders--;
				}
				long player_no =1;
				while(nos_rolls>0)
				{	
					int roll = Integer.parseInt(in.readLine());
					if(player_no>players)
					{
						player_no = 1;
					}
					int cur_pos = player_n_pos.get(player_no);
					player_n_pos.put(player_no, move(cur_pos,snakes_ladders,roll));
					if(player_n_pos.get(player_no)>=100)
						break;
					player_no++;
						
					nos_rolls--;					
				}
				
				for(long i =1;i<=player_n_pos.size();i++)
				{
					System.out.println("Position of player "+i+" is "+player_n_pos.get((i))+".");
					count++;
				}
				testCases--;
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public static int move (int currentPos, HashMap<Integer,Integer> snakes_n_ladders,  int roll)
	{
		int x = 1;
		x = currentPos + roll;
		if( snakes_n_ladders.containsKey(x))
			x =  snakes_n_ladders.get(x);
		
		return x;
	}
}
