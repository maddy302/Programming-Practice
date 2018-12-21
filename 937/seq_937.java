
public class seq_937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int getNthNumber(int[] coeff, int repeat, int kth)
	{
		
		StringBuilder res = new StringBuilder();
		for(int i=1; res.length()<kth+1;i++)
		{
			
		}
		
		return kth;
		
	}
	
	
	public static int getEqOutput(int[] coeff, int index)
	{
		int result = 0;
		int eq = 0;
		for(int i=0; i<coeff.length; i++)
		{
			eq = eq + (int) (coeff[i]*Math.pow(index, i));
		}
		return eq;
		
	}

}
