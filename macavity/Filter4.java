// Pascal Phoa - Lecture27 Homework

//import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Filter4 implements Filter{

	// Attributes
	Filter prev = null;
	String word;
	BlockingQueue<String> bq = new LinkedBlockingQueue<>();
	HashMap<String, Integer> count = new HashMap<>();

	// Constructor
	public Filter4(Filter filter){
		prev = filter;
	}

	@Override
	public void run(){
		try{
			word = prev.getBq().take();
			while(word != null){
				if(word.equals("EOF") && prev.getBq().size() == 0) break;

				// Use HashMap and count frequency of characters
				for(int i = 0; i < word.length();  i++){
					String w = String.valueOf(word.charAt(i));
					Integer val = count.containsKey(w) ? count.get(w) : 0;
					count.put(w, val + 1);
				}
				word = prev.getBq().take();
			}
			
		} catch (Exception e){
			System.out.println("Exception occured.");
		}

		// Display HashMap results
		display();
	}

	@Override
	public BlockingQueue<String> getBq() { return this.bq; }

	// Iterate through HashMap and print out key value pairs of character frequencies
	public void display(){
		Iterator iter = count.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry mapElement = (Map.Entry) iter.next();
			int freq = (int) mapElement.getValue();
			System.out.println(mapElement.getKey() + " : " + freq);
		}
	}
}
