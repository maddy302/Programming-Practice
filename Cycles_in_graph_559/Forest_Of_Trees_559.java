import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//need to fix one issue where the root node should be known or first in the set

public class Forest_Of_Trees_559 {
	static int tree_count = 0;
	static List<String> acorn = new ArrayList<String>();
	int v; //no. of nodes
	Map<String, LinkedList<String>> adj = new HashMap<String, LinkedList<String>>();

	public void addEdge(String a, String b)
	{
		if(adj.containsKey(a))
			adj.get(a).add(b);
		else
		{
			LinkedList<String> temp = new LinkedList<String>();
			temp.add(b);
			adj.put(a, temp);

		}
	}

	public void check_add_node(String a)
	{
		if(!adj.containsKey(a))
		{
			adj.put(a, new LinkedList<String>());
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int num_test_cases = Integer.parseInt(in.readLine());

			List<Forest_Of_Trees_559> graph_head_list = new ArrayList<Forest_Of_Trees_559>();
			while(num_test_cases > 0)
			{
				String s = in.readLine();
				Forest_Of_Trees_559 graph = new Forest_Of_Trees_559();
				while( !s.contains("*"))
				{
					//String temp = in.readLine();
					String[] inp = s.replace(")","").replace("(", "").split(",");
					graph.addEdge(inp[0], inp[1]);
					s = in.readLine();
				}
				s = in.readLine();
				String[] inp = s.split(",");
				for (String x : inp)
					graph.check_add_node(x);


				num_test_cases--;
				graph_head_list.add(graph);
			}


			for(Forest_Of_Trees_559 x : graph_head_list)
				//System.out.println(checkCycles(x));
				checkCycles(x);


		}catch(Exception e)
		{

		}

	}

	private static boolean checkCycles(Forest_Of_Trees_559 x) {

		// TODO Auto-generated method stub
		//Forest_Of_Trees_559 x = graph_head_list.get(0);
		Map<String, LinkedList<String>> adj = x.adj;
		List<String> white = new ArrayList<String>();
		Set<String> temp_set = adj.keySet();

		for(String temp_x : temp_set)
			white.add(temp_x);
		List<String> gray = new ArrayList<String>();
		List<String> black = new ArrayList<String>();


		while(white.size()>0)
		{
			String current_node = white.get(0);
			 check_for_trees_acorns(current_node, x, 0, white );
			
			
		}
		System.out.println("There are "+tree_count+" tree(s) and "+acorn.size()+" acorn(s).");
		tree_count = 0;
		acorn.clear();
		//		System.out.println("Tree Count: "+ tree_count);
		//		for(String acorn_data : acorn)
		//		{
		//			System.out.println(acorn_data);
		//		}

		return false;




	}

	public static void check_for_trees_acorns(String current_node, Forest_Of_Trees_559 x, int recur_count, List<String> white)
	{

		if(recur_count == 0 && x.adj.get(current_node).size()==0)
		{
			acorn.add(current_node);
			white.remove(current_node);
			return;
		}
		white.remove(current_node);
		if(recur_count == 0 && x.adj.get(current_node).size()>0)
		{
			//tree_list.add(1);
			//continue;
			tree_count++;
		}
		if(x.adj.get(current_node).size()>0)
		{
			
			for(String nodes : x.adj.get(current_node))
				check_for_trees_acorns(nodes, x, ++recur_count, white);
		}
	}


}
