import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parking_11364 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int testCases = Integer.parseInt(in.readLine());
			while(testCases>0) {
				String totalShops = in.readLine();
				String[] inp = in.readLine().split(" ");
				int[] minmax = findMinMax(inp);
				
				System.out.println(2*(minmax[1] - minmax[0]));
			testCases--;
			}
		}catch(Exception e) {
			
		}
	}
	
	public static int[] findMinMax(String[] x) {
		int[] minmax = {9999999, -9999999};
		
		
		for(int i=0; i<x.length; i++)
		{
			if(Integer.parseInt(x[i])< minmax[0]) {
				minmax[0] = Integer.parseInt(x[i]);
			}
			if(Integer.parseInt(x[i])> minmax[1]) {
				minmax[1] = Integer.parseInt(x[i]);
			}
		}
		
		return minmax;
	}

}
