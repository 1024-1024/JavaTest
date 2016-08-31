package synchronizede;

public class SyncTest {

	public synchronized void test() {
		System.out.println("test开始..");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("-----子线程开始-----");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("-----子线程结束-----");
			}
		}).start();;
		System.out.println("test结束..");
	}


	public static void main(String[] args) {
		SyncTest sync = new SyncTest();
		for (int i = 0; i < 3; i++) {
			MyThread thread = new MyThread(sync);
			thread.start();
		}
	}
}
