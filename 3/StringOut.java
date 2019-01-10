
public class StringOut extends Thread {
		String[] s;
		long sleepTime;
		
		public StringOut(String[] s, long sleepTime){
			this.s = s;
			this.sleepTime = sleepTime;
		}
		
		public void run(){
			for(int i=0; i<s.length; i++){
				System.out.println(s[i]);
				try{
					Thread.sleep(sleepTime);
				}catch (InterruptedException e){
					
				}
			}
		}
}
