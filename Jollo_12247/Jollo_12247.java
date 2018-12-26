import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Jollo_12247 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		try {
//			
////			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
////			String inp = in.readLine();
//			int[][] inputMatrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
////			while(!inp.isEmpty())
////			{
////				
////			}
////			
//			int rows = inputMatrix.length;
//			int cols = inputMatrix.length;
//			int sum = 0;
//			int j = 0;
//			for(int i=0;i<rows;)
//			{
//				if(i == 0)
//				{
//					sum = sum + inputMatrix[i][j+1];
//				}
//				if(i!=0 && j<cols-1) {
//				sum = sum + inputMatrix[i][j+1] + inputMatrix[i][j];
//				
//				}
//				if(j==cols-1) {
//					sum = sum + inputMatrix[i][j];
//				}
//				i++;
//				j++;
//			}
//			System.out.println(sum);
////			
////			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
////			String input = in.readLine();
////			String[] inpArray = input.split(",");
////			Stack<String> x = new Stack<String>();
////			boolean res = true;
////			for(int i=0;i<inpArray.length;i++)
////			{
////				if(inpArray[i].equals("(") || inpArray[i].equals("{") || inpArray[i].equals("["))
////				{
////					x.push(inpArray[i]);
////				}
//////				x.push(inpArray[i]);
//////				else
//////				{
////					if(inpArray[i].equals(")"))
////							if(!x.pop().equals("("))
////								res = false;
////					if(inpArray[i].equals("}"))
////						if(!x.pop().equals("{"))
////							res = false;
////					if(inpArray[i].equals("]"))
////						if(!x.pop().equals("["))
////							res = false;
////									
////				}
//////			}
////			System.out.println(res);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//

	public static void main(String[] args) {
		try {
			Stack<Integer> cards = new Stack<Integer>();
			for(int i=1 ; i<= 52 ;i++)
				cards.push(i);
			
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			
			while(!inp.equals("0 0 0 0 0")) {
				String[] x = inp.split(" ");
				ArrayList<Integer> princess = new ArrayList<Integer>();
				ArrayList<Integer> prince = new ArrayList<Integer>();
				int princeWin = 0;
				int princessWin = 0;
				int res = 0;
				princess.add(Integer.parseInt(x[0]));
				princess.add(Integer.parseInt(x[1]));
				princess.add(Integer.parseInt(x[2]));
				prince.add(Integer.parseInt(x[3]));
				prince.add(Integer.parseInt(x[4]));
//				cards.remove(cards.indexOf(Integer.parseInt(x[0])));
//				cards.remove(cards.indexOf(Integer.parseInt(x[1])));
//				cards.remove(cards.indexOf(Integer.parseInt(x[2])));
//				cards.remove(cards.indexOf(Integer.parseInt(x[3])));
//				cards.remove(cards.indexOf(Integer.parseInt(x[4])));
				
				Collections.sort(princess);
				Collections.reverse(princess);
				Collections.sort(prince);
				Collections.reverse(prince);
				if(prince.get(0) > princess.get(0) && prince.get(1) > princess.get(0))
				{
					res = cards.remove(0);
					
				}
				else if(prince.get(0)>princess.get(0) && prince.get(1)<princess.get(0))
				{
					res = cards.get(cards.indexOf(princess.get(0))+1);
				}
				else if(princess.get(0)>prince.get(0) && princess.get(1)<prince.get(0))
				{
					res = cards.get(cards.indexOf(princess.get(1))+1);
				}
				else
				{
					res = -1;
				}
				
			
			System.out.println(res);
			inp = in.readLine();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
