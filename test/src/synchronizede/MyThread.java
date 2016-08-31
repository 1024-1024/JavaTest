package synchronizede;

public class MyThread extends Thread {

	private SyncTest syncTest;
	public MyThread(SyncTest syncTest) {
		this.syncTest = syncTest;
	}
	
	public void run() {
		syncTest.test();
	}
}
