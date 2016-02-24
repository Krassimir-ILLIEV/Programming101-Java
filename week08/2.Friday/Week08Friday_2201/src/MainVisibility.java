import java.lang.Thread.State;

public class MainVisibility {

	public static void main(String[] args) throws InterruptedException{
		
		VisibilityThreadExample tr= new VisibilityThreadExample();
		tr.start();
		
		tr.sleep(1000);
		//while (tr.getState()==State.TIMED_WAITING)
		//	;
		tr.setToFalse();
		System.out.println(tr.keepRunning);
		//tr.join(2000);
		//tr.setToFalse();
		System.out.println(tr.getValue());
		//tr.interrupt();
		
	}
}
