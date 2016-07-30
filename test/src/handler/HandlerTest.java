package handler;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import android.text.TextUtils;

public class HandlerTest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedBlockingQueue<>();
		
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					queue.add("aa:"+Thread.currentThread().getId());
				}
			}).start();;
		}
		
		for(;;) {
			String a = queue.poll();
			if (a == null) {
				continue;
			}
			System.out.println(a);
		}
		
	}
}
