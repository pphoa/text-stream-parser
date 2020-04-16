// Pascal Phoa - Lecture27 Homework

//import java.io.*;
//import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Filter2 implements Filter{

	// Attributes
	Filter prev = null;
	String line;
	BlockingQueue<String> bq = new LinkedBlockingQueue<>(10);

	// Constructor
	public Filter2(Filter filter){
		prev = filter;
	}

	@Override
	public void run(){
		try{
			line = prev.getBq().take();

			// Strip line from non-alphabet characters and uppercase them
			while(line != null){
				if(line.equals("EOF") && prev.getBq().size() == 0) break;
				line = modifyLine(line);
				bq.put(line);	
				line = prev.getBq().take();
			}
			bq.put("EOF");
		} catch (Exception e){
			System.out.println("Error.");
		}	
	}

	@Override
	public BlockingQueue<String> getBq() { return this.bq; };

	// Function that gets rid of non-alpha chars and uppercases them
	public String modifyLine(String line){
		StringBuilder str = new StringBuilder();

		for(int i = 0; i < line.length(); i++){
			char a = line.charAt(i);

			// We want spaces between words so we can split them later
			if(a == ' '){
				str.append(a);
				continue;
			}
			int asc = (int) a;
			
			// Uppercase letters
			if(asc >= 65 && asc <= 90) str.append(a);
			// Lowercase letters
			if(asc >= 97 && asc <= 122) str.append(Character.toUpperCase(a));
		}

		return str.toString();
	}
}
