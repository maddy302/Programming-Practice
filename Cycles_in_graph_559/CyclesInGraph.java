import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CyclesInGraph {
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
	
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int num_test_cases = Integer.parseInt(in.readLine());
			
			List<CyclesInGraph> graph_head_list = new ArrayList<CyclesInGraph>();
			while(num_test_cases > 0)
			{
				String s = in.readLine();
				CyclesInGraph graph = new CyclesInGraph();
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
			
			
			for(CyclesInGraph x : graph_head_list)
				//System.out.println(checkCycles(x));
				checkCycles(x);
			
			
		}catch(Exception e)
		{
			
		}

	}

	private static boolean checkCycles(CyclesInGraph x) {
		
		// TODO Auto-generated method stub
		//CyclesInGraph x = graph_head_list.get(0);
		Map<String, LinkedList<String>> adj = x.adj;
		List<String> white = new ArrayList<String>();
		Set<String> temp_set = adj.keySet();
		
		for(String temp_x : temp_set)
			white.add(temp_x);
		List<String> gray = new ArrayList<String>();
		List<String> black = new ArrayList<String>();
		
		//black.add(white.get(0));
		//boolean cycle_not_present = cycleUtil(white.get(0), white, gray, black, adj, adj.get(white.get(0)));
		//boolean cycle_not_present = cycleUtil(white.get(0), white, gray, black, x);
		//return cycle_not_present;
		
		while(white.size()>0)
		{
			String current_node = white.get(0);
			int res = dfs(current_node, white, black, gray, x,0);
			if(res == 1)
				return true;
			else if(res == 0)
			{
				white.remove(current_node);
				acorn.add(current_node);
			}
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
	
	private static int dfs(String current_node, List<String> white, List<String> black, List<String> gray, CyclesInGraph x, int recur_count) {
		// TODO Auto-generated method stub
		if(recur_count == 0 && x.adj.get(current_node).size()==0)
			return 0;
		
		if(recur_count == 0 && x.adj.get(current_node).size()>0)
			++tree_count;
		
		moveNode(current_node, white, gray);
		
		for(String neighbour : x.adj.get(current_node))
		{
			if(black.contains(neighbour))
				continue;
			if(gray.contains(neighbour))
				return 1;
			if(dfs(neighbour, white, black, gray, x, ++recur_count)==1)
				return 1;
		}
		
		moveNode(current_node, gray, black);
			 
		
		return -1;
	}

	private static void moveNode(String current_node, List<String> fromList, List<String> toList) {
		// TODO Auto-generated method stub
		fromList.remove(current_node);
		toList.add(current_node);
		
	}

	private static boolean cycleUtil(String Node, List<String> white, List<String> gray, List<String> black, CyclesInGraph graph)
	{
		if(black.contains(Node) || gray.contains(Node))
			return false;
		else
		{
			boolean temp_res = true;
			for(String node_temp : graph.adj.get(Node))
			{
				
				gray.add(Node);
				temp_res =  temp_res & cycleUtil(node_temp, white, gray, black, graph);
			}
			return temp_res;
		}
	}
	
	
	
	private static boolean cycleUtil(String node, List<String> white, List<String> gray, List<String> black, Map<String, LinkedList<String>> adj, LinkedList<String> adj_list) {
		// TODO Auto-generated method stub
		boolean temp_result = true;
		/*if(adj.get(node) ==null || adj.get(node).size()==0)
		{
			black.add(node);
			white.remove(node);
			gray.remove(node);
			return true;
		}*/
		 if(black.contains(node) /*|| gray.contains(node)*/)
			return false;
		else if(adj.get(node).size()>0)
		{
			for(String node_temp : adj.get(node))
			{
				gray.add(node_temp);//add node
				temp_result = temp_result & cycleUtil(node_temp, white, gray, black, adj, adj.get(node_temp));
				if(!temp_result)
					return false;
				else
				{
					black.add(node_temp);
				return true;
				}
			}
			return temp_result;
		}
		
		
		return false;
	}

	
	public static void check_for_trees_acorns(String current_node, CyclesInGraph x, int recur_count, List<String> acorn, List<Integer> tree_list, List<String> white)
	{
		
		if(recur_count == 0 && x.adj.get(current_node).size()==0)
		{
			acorn.add(current_node);
			white.remove(current_node);
			return;
		}
		if(recur_count == 0 && x.adj.get(current_node).size()>0)
		{
			tree_list.add(1);
			//continue;
		}
		 if(x.adj.get(current_node).size()>0)
		{
			 white.remove(current_node);
			for(String nodes : x.adj.get(current_node))
				check_for_trees_acorns(nodes, x, ++recur_count, acorn, tree_list, white);
		}
	}
	

}
