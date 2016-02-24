
public class VisibilityThreadExample extends Thread {

	/*volatile*/ public boolean keepRunning=true;
	
	public void setToFalse(){
		keepRunning=false;
		//System.out.println(keepRunning);
	}
	
	public boolean getValue(){
		return keepRunning;
	}
	public void interrupt(){
		
	}
	public void run(){
		boolean b=getValue();
		while(b){
			b=keepRunning;
			//System.out.println(keepRunning);
		}
		
		System.out.println("Done.");
	}
}
