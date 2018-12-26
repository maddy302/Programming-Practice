import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchNessy {

	public static void main(String[] args) {

	    try{
	    //System.out.println("Hello world!");
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String inp = in.readLine();
	    int testCases = Integer.parseInt(inp);
	   
	    while(testCases>0){
	      System.out.println(testCases);
	      String[] i = in.readLine().split(" ");
	      int x = Integer.parseInt(i[0]);
	      int y = Integer.parseInt(i[1]);
	      
	      int xreq = (x-2)/3 + (((x-2)%3 == 0)?0:1);
	      int yreq = (y-2)/3 + (((y-2)%3 == 0)?0:1);
	      System.out.println(xreq*yreq);
	     testCases--; }
	}
	catch(Exception e){

	}
		// TODO Auto-generated method stub

	}

}
