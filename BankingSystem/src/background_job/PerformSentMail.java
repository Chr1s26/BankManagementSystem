package background_job;

public abstract class PerformSentMail extends Thread{
	
	public abstract void sentEmailThread();

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
			sentEmailThread();
	}
	
}
