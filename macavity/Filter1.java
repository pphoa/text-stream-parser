// Pascal Phoa - Lecture27 Homework

import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Filter1 implements Filter{

	// Attributes
	String line;
	BufferedReader br = null;
	FileReader fr = null;
	BlockingQueue<String> bq = new LinkedBlockingQueue<>(10);

	// Constructor
	public Filter1(String f){
		System.out.println("--- " + f + " ---");
		String file = f;
		try{ fr = new FileReader(file); } catch (FileNotFoundException e){ System.out.println(e.getMessage()); }
	}

	@Override
	public void run(){
		try{
			br = new BufferedReader(fr);
			while((line = br.readLine()) != null){
				bq.put(line);
			}
			bq.put("EOF");

		} catch (Exception e){
			System.out.println("Exception occured.");
		}
	}

	@Override
	public BlockingQueue<String> getBq(){ return this.bq; }
}
