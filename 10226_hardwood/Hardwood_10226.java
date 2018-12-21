import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Hardwood_10226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int count_testcases = Integer.parseInt(in.readLine());
			List<HashMap<String, Integer>> input_data = new ArrayList<HashMap<String,Integer>>();
			String input = in.readLine();
			int[] total_count = new int[count_testcases];
			int test_case_count = 0;
			while(count_testcases>0)
			{
				
				input = in.readLine();
				Map<String, Integer> temp = new TreeMap<String, Integer>();
				int total = 0;
				
				while(!input.isEmpty())
				{	
					if(temp.containsKey(input))
					{
						int temp_count = temp.get(input);
						temp.replace(input, ++temp_count);
					}
					else
						temp.put(input, 1);
					
					input = in.readLine();
					total++;
				}
				
				Set<String> keys = temp.keySet();
				Iterator<String> itr = keys.iterator();
				while(itr.hasNext())
				{
					String key = itr.next();
					System.out.println(key + " " +String.format("%.4f", temp.get(key)*100.0/(total+1)));
					
				}
				//System.out.println();
				count_testcases--;
			}
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
