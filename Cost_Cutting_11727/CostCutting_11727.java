import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CostCutting_11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			while(!inp.isEmpty()) {
				int testCases = Integer.parseInt(inp);
				int slno = 1;
				while(testCases>0)
				{
					String[] operands = in.readLine().split(" ");
					List<String> oprnds = Arrays.asList(operands);
					Collections.sort(oprnds);
					System.out.println("Case "+slno+": "+oprnds.get(1));
					testCases--;
					slno++;
				}
			}
			
		}catch (Exception e) {
			
		}
	}

}
