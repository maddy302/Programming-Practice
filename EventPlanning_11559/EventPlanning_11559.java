import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EventPlanning_11559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = "";
			while(!(inp = in.readLine()).isEmpty())
			{
				String[] temp = inp.split(" ");
				int nos_participants = Integer.parseInt(temp[0]);
				int budget = Integer.parseInt(temp[1]);
				int hotels = Integer.parseInt(temp[2]);
				int nos_weeks = Integer.parseInt(temp[3]);
				
				int cost = 0;
				int min_cost = 999999999;
				int temp_hotels = hotels;
				while(temp_hotels > 0)
				{
				
				
				int cost_per_person = Integer.parseInt(in.readLine());
				String[] availability = in.readLine().split(" ");
				
				
				for(int i=0; i<availability.length ; i++) {
					if(Integer.parseInt(availability[i]) >= nos_participants && 
							nos_participants*cost_per_person <= budget)
					{
						cost = nos_participants*cost_per_person;
						if(cost<min_cost)
							min_cost = cost;
						break;
					}
				}
				temp_hotels--;
				}
				if(cost>0)
					System.out.println(min_cost);
				else
					System.out.println("stay home");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
