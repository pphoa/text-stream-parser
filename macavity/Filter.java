// Pascal Phoa - Lecture27 Homework

import java.util.concurrent.BlockingQueue;

public interface Filter extends Runnable{
	public void run();
	public BlockingQueue<String> getBq();
}
