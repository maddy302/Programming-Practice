import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javafx.collections.transformation.SortedList;

public class Borrowers_230 {
	
	 class Book implements Comparable<Book>{

		String author;
		String title;
		
		public Book(String title, String auth) {
			author = auth;
			this.title = title;
		}
		
		
		@Override
		public String toString() {
			return "Book [author=" + author + ", title=" + title + "]";
		}


		@Override
		public int compareTo(Book o) {
			// TODO Auto-generated method stub
			if(this.author.equals(o.author)) {
				return this.title.compareTo(o.title);
			}else {
				return this.author.compareTo(o.author);
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int end_count = 0;
		Borrowers_230 main_obj = new Borrowers_230();
		List<Book> book_list = new ArrayList<Book>();
		HashMap<String, String> book_list_map = new HashMap<String, String>();
		List<Book> borrowed_list = new ArrayList<Book>();
		List<Book> return_list = new ArrayList<Book>();
		//List<Book> sorted_list = new SortedList<>(source, comparator)
		String x = in.readLine();
		while(end_count != 2) {
			
			if(!x.equalsIgnoreCase("End") && end_count==0)
			{
				String[] book = x.split(" by ");
				book_list_map.put(book[0], book[1]);
				book_list.add(main_obj.new Book(book[0],book[1]));
				borrowed_list.add(main_obj.new Book(book[0],book[1]));
				
			}
			
			if(x.equalsIgnoreCase("End"))
				end_count++;
			if(x.contains("BORROW")) {
				//String[] book1 = x.split(" ");
				String book_temp = x.substring(7, x.length());
				int index = indexOfObj(main_obj.new Book(book_temp, book_list_map.get(book_temp)), borrowed_list);
				borrowed_list.remove(index);
			}
			
			if(x.contains("RETURN")) {
				String book_temp = x.substring(7, x.length());
				return_list.add(main_obj.new Book(book_temp, book_list_map.get(book_temp)));
			}
			
			if(x.equals("SHELVE")) {
				Collections.sort(return_list);
				Collections.sort(book_list);
				Collections.sort(borrowed_list);
				int i=0;
				borrowed_list.addAll(return_list);
				Collections.sort(borrowed_list);
				while(return_list.size()!=0) {
					int index = indexOfObj(return_list.get(0), borrowed_list);
					if(index==0)
						System.out.println("Put "+return_list.get(0).title+" first");
					else
						System.out.println("Put "+return_list.get(0).title+" after "+borrowed_list.get(index-1).title);
					return_list.remove(0);
				}
				System.out.println("END");
			}
			
			if(end_count!=2)	
				x = in.readLine();
			else
				break;
		}
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int indexOfObj (Book x, List<Book> y) {
		int index=-1;
			
		for(int i=0;i<y.size();i++) {
//			if((y.get(i)).author.equals(x.author) && (y.get(i)).title.equals(x.title))
			if((y.get(i)).title.equals(x.title))
				return i;
		}
		
		return index;
	}

}
