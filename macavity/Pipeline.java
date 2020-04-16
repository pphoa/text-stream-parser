// Pascal Phoa - Lecture27 Homework 

public class Pipeline{
	String file;

	public void setup(String f){
		file = f;

		Filter filter1 = new Filter1(file);
		Runnable runnable1 = filter1;
		Thread thread1 = new Thread(runnable1);
		thread1.start();

		Filter filter2 = new Filter2(filter1);
		Runnable runnable2 = filter2;
		Thread thread2 = new Thread(runnable2);
		thread2.start();

		Filter filter3 = new Filter3(filter2);
		Runnable runnable3 = filter3;
		Thread thread3 = new Thread(runnable3);
		thread3.start();

		Filter filter4 = new Filter4(filter3);
		Runnable runnable4 = filter4;
		Thread thread4 = new Thread(runnable4);
		thread4.start();

	}

}
