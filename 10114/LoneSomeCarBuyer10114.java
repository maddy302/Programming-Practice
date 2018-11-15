import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LoneSomeCarBuyer10114 {

	class LoanDetails{

		LoanDetails(int m, float d, float l){
			months = m;
			down_payment = d;
			loan_amount = l;
		}

		int months;
		float down_payment, loan_amount;
		float[] depriciation = new float[12];


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String inp = in.readLine();
			String[] loanDetails = inp.split(" ");
			LoneSomeCarBuyer10114 y = new LoneSomeCarBuyer10114();
			while(Integer.parseInt(loanDetails[0]) > 0) {
				int period = Integer.parseInt(loanDetails[0]);
				float down_payment = Float.parseFloat(loanDetails[1]);
				float principle = Float.parseFloat(loanDetails[2]);
				float [] depriciation = new float[period+1];
				int countDep = Integer.parseInt(loanDetails[3]);
				int tempCount = countDep;
				float prev = 0;
				while(tempCount>0) {
					String[] depcrDetails = in.readLine().split(" ");
					int indx = Integer.parseInt(depcrDetails[0]);
					depriciation[indx] = Float.parseFloat(depcrDetails[1]);
					tempCount--;
				}
				
				prev = depriciation[0];
				for(int i=0; i<=period ; i++) {
					if(depriciation[i] == 0) {
						depriciation[i] = prev;
					}
					else {
						prev = depriciation[i];
					}
					
				}

				evaluate(period, down_payment, principle, depriciation);
				inp = in.readLine();
				loanDetails = inp.split(" ");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void evaluate(int period, float down_payment, float principle, float[] depriciation) {
		float car_worth = principle + down_payment;
		float borrower_owe = principle;
		down_payment = principle/period;
		for(int i=0; i <=period; i++) {
			
			car_worth = car_worth - (depriciation[i]*car_worth);
			
			
			if(car_worth > borrower_owe) {
				if(i==1)
					System.out.println(i + " month");
				else
					System.out.println(i + " months");
				break;
			}
			borrower_owe = borrower_owe - down_payment;
			//System.out.println("Car worth: " + car_worth + " ; Owe amount: "+ borrower_owe);
			
		}
	}

}
