import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {



	public static void sayHello(int x) {
		System.out.println("Hello problem from inside "+x);
	}

	public static void execute(String input) throws IOException {
		//System.out.println("Enter the value of n");
		//InputReader in = new InputReader();
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//String input = in.readLine();
		int inpInt1 = 0;
		int inpInt2 = 0;
		int inpInt1Copy = 0;
		int inpInt2CCopy = 0;
		try {
			inpInt1 = Integer.parseInt(input.split(" ")[0]);
			inpInt2 = Integer.parseInt(input.split(" ")[1]);
		}catch(Exception x) {
			int i=0,j=0;
			String[] inpException  = input.split(" ");
			String[] ins = new String[2];
			while(i<inpException.length) {
				if(isNumeric(inpException[i])) {
				ins[j] = inpException[i];
				j++;
				}
				i++;
			}
			inpInt1 = Integer.parseInt(ins[0]);
			inpInt2 = Integer.parseInt(ins[1]);
			
		}
		int inpInt2Copy = inpInt2;
		inpInt1Copy = inpInt1;
		inpInt2CCopy = inpInt2;
		int cycle_count = 0;
		int cycle_count_max = -999;
		if(inpInt2<inpInt1) {
			int temp = inpInt1;
			inpInt1 = inpInt2;
			inpInt2 = temp;
			inpInt2Copy = inpInt2;
		}
		while(inpInt2>=inpInt1) {
			cycle_count = getCycleCount(inpInt2);
			if(cycle_count>cycle_count_max) {
				cycle_count_max = cycle_count;
			}
			inpInt2--;
		}



		System.out.println( inpInt1Copy+" "+inpInt2CCopy+" "+cycle_count_max);
	}

	public static boolean isNumeric(String x) {
		try {
			int l = Integer.parseInt(x);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	private static int getCycleCount(int inpInt) {
		int cycle_count=0;
		while(inpInt>0) {
			//System.out.println(inpInt+" ");
			if(inpInt==1) {
				cycle_count++;
				break;
			}

			else if (inpInt%2 ==1) {
				inpInt = 3*inpInt + 1;
			}
			else {
				inpInt = inpInt/2;
			}
			cycle_count++;
		}
		return cycle_count;
	}

	public static void readInp() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String s="";
			ArrayList inputs = new ArrayList();
			while((s = in.readLine())!=null && !(s.trim().equalsIgnoreCase(""))) {
				inputs.add(s);
			}

			for(int i=0;i<inputs.size();i++) {
				execute(inputs.get(i).toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return null;

	}

	public static void main(String[] args) {
		try {
			//execute();
			readInp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
