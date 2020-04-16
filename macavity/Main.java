// Pascal Phoa - Lecture27 Homework 

public class Main{
	public static void main(String args[]){
		Pipeline test1 = new Pipeline();
		test1.setup("macavity.txt");

		try{ Thread.sleep(1500); } catch (Exception e) {}

		Pipeline test2 = new Pipeline();
		test2.setup("hamlet.txt");

		try{ Thread.sleep(1500); } catch (Exception e) {}

		Pipeline test3 = new Pipeline();
		test3.setup("bohemian.txt");
	}
}

