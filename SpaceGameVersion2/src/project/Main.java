package project;

public class Main {

	public static void main(String[] args) {
		 MainMenu mainMenu=new MainMenu();
		   
	     while (true) {
	    	 mainMenu.updateJFrame();
	    	 try {
	    		 Thread.sleep(100);
	    	 } catch (InterruptedException e) {
	    		 e.printStackTrace();
			}
		}
	}

}
