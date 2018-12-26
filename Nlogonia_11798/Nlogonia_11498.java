import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nlogonia_11498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String testCases ="";
			//testCases = in.readLine();
			while((testCases = in.readLine())!=null && testCases!="0") {
			int testCasesInt = Integer.parseInt(testCases);
			String[] divison = in.readLine().split(" ");
			int divx = Integer.parseInt(divison[0]);
			int divy = Integer.parseInt(divison[1]);
				while(testCasesInt > 0) 
				{
					
					String[] coordinates = in.readLine().split(" ");
					System.out.println(compareCoordinates(divx, divy, coordinates));
					testCasesInt --;
				}
				
		}
		}
		catch (Exception e) {
			
		}
	}
	
	public static String compareCoordinates(int divx, int divy, String[] coordinates) {
		String res = "";
		int x = Integer.parseInt(coordinates[0]);
		int y = Integer.parseInt(coordinates[1]);
		if( x == divx || y == divy)
			return "divisa";
		else if (x > divx && y > divy)
			return "NE";
		else if (x < divx && y > divy)
			return "NO";
		else if (x < divx && y < divy)
			return "SO";
		else if (x > divx && y < divy)
			return "SE";
		return res;
	}

}
