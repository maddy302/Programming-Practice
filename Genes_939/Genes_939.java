import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Genes_939 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Genes_939 obj_main = new Genes_939();
			TreeMap<String, Person> relation_tree = new TreeMap<String, Person>();
			List<Person> list_person = new ArrayList<Person>();
			int entries_nos = Integer.parseInt(in.readLine());
			
			while(entries_nos>0) {
				String[] inp = in.readLine().split(" ");
				if(inp[1].equals("dominant") || inp[1].equals("recessive") || inp[1].equals("non-existent"))
				{
					relation_tree.put(inp[0], obj_main.new Person(inp[0],"","",inp[1]));
				}
				else {
					if(relation_tree.containsKey(inp[1])) {
						Person temp  = relation_tree.get(inp[1]);
						String temp_gene = temp.genes;
						if(temp.parent1.isEmpty())
							temp.parent1 = inp[0];
						else
							temp.parent2 = inp[0];
						relation_tree.put(inp[1], temp);
					}else {
						relation_tree.put(inp[1], obj_main.new Person(inp[1],inp[0],"",""));
					}
				}
				entries_nos--;
			}
			
			//System.out.println("Loading done");
			
			fillUp(relation_tree);
			//System.out.println(relation_tree.toString());
			Set<String> keys = relation_tree.keySet();
			//System.out.println(keys.toString());
			Iterator<String> itr = keys.iterator();
			//Person temp = null;
			
			while(itr.hasNext()) {
				String key = itr.next();
				Person temp = relation_tree.get(key);
				System.out.println(temp.person + " "+ temp.genes);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public class Person{
		String person = "";
		String parent1 = "";
		String parent2 = "";
		String genes = "";
		@Override
		public String toString() {
			return "Person [person=" + person + ", parent1=" + parent1 + ", parent2=" + parent2 + ", genes=" + genes
					+ "]";
		}
		public Person(String person, String parent1, String parent2, String genes) {
			this.person = person;
			this.parent1 = parent1;
			this.parent2 = parent2;
			this.genes = genes;
		}
		public String getPerson() {
			return person;
		}
		public void setPerson(String person) {
			this.person = person;
		}
		public String getParent1() {
			return parent1;
		}
		public void setParent1(String parent1) {
			this.parent1 = parent1;
		}
		public String getParent2() {
			return parent2;
		}
		public void setParent2(String parent2) {
			this.parent2 = parent2;
		}
		public String getGenes() {
			return genes;
		}
		public void setGenes(String genes) {
			this.genes = genes;
		}
		
	}

	public static TreeMap<String, Person> fillUp(TreeMap<String, Person> x)
	{
		Set<String> y = x.keySet();
		Iterator<String> it = y.iterator();
		for(int i=0;i<y.size();i++)
		{
			String key = it.next();
			Person temp = x.get(key);
			String gene = findGene(x, temp);
//			temp.setGenes(gene);
//			x.put(key, temp);
		}
		
		return x;
	}
	
	public static String findGene(TreeMap<String, Person> x, Person y)
	{
		String genes = "";
		if(!y.genes.isEmpty())
		{
			return y.genes;
		}
		else {
			String p1 = y.parent1;
			String p2 = y.parent2;
			String p1_genes = x.get(p1).genes;
			String p2_genes = x.get(p2).genes;

			if(p1_genes.isEmpty()) {
				String temp_gene = findGene(x, x.get(p1));
//				Person temp = x.get(p1);
//				temp.setGenes(temp_gene);
//				x.put(p1, temp);
				//return temp_gene;
				//return findGene(x, y);
			}
			if(p2_genes.isEmpty()) {
				String temp_gene = findGene(x, x.get(p2));
//				Person temp = x.get(p2);
//				temp.setGenes(temp_gene);
//				x.put(p2, temp);
				//return temp_gene;
				//return findGene(x, y);
			}
			p1_genes = x.get(p1).genes;
			p2_genes = x.get(p2).genes;
			if(!p1_genes.isEmpty() && !p2_genes.isEmpty()) {
				genes = evaluateGene(p1_genes, p2_genes);
				y.setGenes(genes);
				x.put(y.person, y);
				return genes;
			}
		}
		
		
		return genes;
	}
	
	public static String evaluateGene(String p1_genes, String p2_genes) {
		
		
		if(p1_genes.equals("non-existent"))
		{
			if(p2_genes.equals("non-existent"))
				return "non-existent";
			else if(p2_genes.equals("dominant"))
				return "recessive";
			else
				return "non-existent";
		}
		else if(p1_genes.equals("dominant"))
		{
			if(p2_genes.equals("non-existent"))
				return "recessive";
			else if(p2_genes.equals("dominant"))
				return "dominant";
			else
				return "dominant";
		}
		else
		{
			if(p2_genes.equals("non-existent"))
				return "non-existent";
			else if(p2_genes.equals("dominant"))
				return "dominant";
			else
				return "recessive";
		}
		
		
//		
//		if(p1_genes.equalsIgnoreCase("dominant") && p2_genes.equalsIgnoreCase("dominant")) 
//		{
//			return "dominant";
//		}
//		
//		else if((p1_genes.equals("dominant") && p2_genes.equals("recessive")) || (p1_genes.equals("recessive") && p2_genes.equals("dominant"))) {
//			return "dominant";
//		}
//		
//		else if(p1_genes.equalsIgnoreCase("non-existent") && p2_genes.equalsIgnoreCase("non-existent")) {
//			return "recessive";
//		}
//		else if((p1_genes.equals("non-existent") && p2_genes.equals("recessive")) || (p1_genes.equals("recessive") && p2_genes.equals("non-existent"))) {
//			return "non-existent";
//		}
//		else if((p1_genes.equals("non-existent") && p2_genes.equals("dominant")) || (p1_genes.equals("dominant") && p2_genes.equals("non-existent"))) {
//			return "recessive";
//		}
//		else
//			return "non-existent";
	}

}
