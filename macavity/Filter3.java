// Pascal Phoa - Lecture27 Homework

//import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Filter3 implements Filter{

	// Attributes
	BlockingQueue<String> bq = new LinkedBlockingQueue<>(20);
	List<String> words = new ArrayList<>();
	Filter prev = null;
	String line;

	// Constructor
	public Filter3(Filter filter){
		prev = filter;
	}

	@Override
	public void run(){
		try{
			line = prev.getBq().take();
			while(line != null){

				if(line.equals("EOF") && prev.getBq().size() == 0) break;

				// Split lines into words and put in next block
				words = Arrays.asList(line.split(" "));
				for(String w : words){
					bq.put(w);
				}	
				line = prev.getBq().take();
			}
			bq.put("EOF");

		} catch (Exception e){
			System.out.println("Exception occured.");
		}
	}

	@Override
	public BlockingQueue<String> getBq(){ return this.bq; }
}
