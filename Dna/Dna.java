import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*The following problem is related to bioinformatics tasks. In order to help in DNA research you will be asked to write an algorithm to find all occurrences of the DNA segment in a given DNA string. But that would be too easy for you. So please write an algorithm to find all occurrences of segment S in DNA string, with maximum allowed mismatches of M. By mismatch, we mean the minimum of total number of substitutions, deletions, insertions necessary to perform on the DNA slice in order to completely match the given segment. You need to look at the DNA slices with the same length as a given pattern. E.g. the segments 'AGTTATC' -> 'AGTATGC' have only 2 mismatches. 
For the DNA string 'CGCCCGAATCCAG' and the segment 'CCC' the first match with the maximum allowed mismatch of '1' is 'CGC', the second one is 'GCC', the third one is 'CCC' and so on. 
For the given segment 'CCC', the DNA string 'CGCCCGAATCCAG' and the maximum allowed mismatch of '1' the list of the matches is 'CGC GCC CCC CCG TCC CCA' 

The DNA string length is in range [100, 300] 
The M is in range [0, 40] 
The segment S length is in range [3, 50]
Input:
Your program should read lines from standard input. Each line contains a segment of DNA, the maximum allowed mismatches M and the DNA string, separated by whitespace.
Output:
Print out all the occurrences of a segment S in the DNA string in order from the best match, separated by whitespace, taking into account the number of allowed mismatches. If there are several segments with the equal matches, print them in alphabetical order. Print out 'No match' if there is no such occurrence.
Test 1
Test Input Download Test InputCCC 1 CGCCCGAATCCAG
Expected Output Download Test OutputCCC CCA CCG CGC GCC TCC
Test 2
Test Input Download Test InputGCGAG 2 CCACGGCCTATGTATTTGCAAGGATCTGGGCCAGCTAAATCAGCACCCCTGGAACGGCAAGGTTCATTTTGTTGCGCGCATAG
Expected Output Download Test OutputGCAAG GCAAG GCCAG GCGCG GCGCA GCTAA*/
public class Dna {
	  /**
	   * Iterate through each line of input.
	   */
	  public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      System.out.println(line);
	      break;
	    }
	    
	    String[] inputs = line.split(" ");
	    String dna1 = inputs[0];
	    String dna2 = inputs[2];
	    int max_mismatch = Integer.parseInt(inputs[1]);
	    
	    System.out.println(dna1 + " + " + dna2 + " "+ max_mismatch);
	    
	    
	    
		String second = dna2;
		String first = dna1;
		int mismatch = max_mismatch; 
		List<String> list = new ArrayList<String>();
		for(int i = 0; i <= second.length() - first.length(); i++){
			String substring = second.substring(i, i+ first.length());
			boolean isCheck = checkStringMismatch(first, substring, mismatch);
			if(isCheck) {
				list.add(substring);
			}
		}
		
		java.util.Collections.sort(list);
		if(list.size() == 0) {
			System.out.println("No Match");
		}
		else {
			System.out.println(String.valueOf(list));
		}
		

	    
	  }
	  
		public static boolean checkStringMismatch(String first, String substring, int mismatch) {
		int count = 0;
		for(int j = 0; j < substring.length(); j++) {
			if(count > mismatch) {
				return false;
			}
			
			
			if(first.charAt(j) != substring.charAt(j)) {
				
				count++;
			}
		}
		
		return count > mismatch ? false : true;
	}

}
