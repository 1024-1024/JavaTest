package handler;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import android.text.TextUtils;

public class HandlerTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedBlockingQueue<>();
		
		for (int i = 0; i < 10; i++) {
			final int num = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(num * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					queue.add("aa:"+Thread.currentThread().getId());
				}
			}).start();
		}
		
		for(;;) {
			String a = queue.poll();
			if (a == null) {
				continue;
			}
			System.out.println("---取出了数据");
			System.out.println(a);
		}
		
	}
}
