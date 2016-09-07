package handler;

import android.os.Handler;
import android.os.Looper;

public class MutiHandler {
	private Handler handler1 = new Handler(Looper.getMainLooper()){
		public void handleMessage(android.os.Message msg) {
			try {
				System.out.println("handler1:开始执行");
				Thread.sleep(2000);
				System.out.println("handler1:执行结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	};
	Handler handler2 = new Handler(Looper.getMainLooper()){
		public void handleMessage(android.os.Message msg) {
			try {
				System.out.println("handler2:开始执行");
				Thread.sleep(2000);
				System.out.println("handler2:执行结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	};
	Handler handler3 = new Handler(Looper.getMainLooper()){
		public void handleMessage(android.os.Message msg) {
			try {
				System.out.println("handler3:开始执行");
				Thread.sleep(2000);
				System.out.println("handler3:执行结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	};
	public static void main(String[] args) {
		MutiHandler mutiHandler = new MutiHandler();
		mutiHandler.handler1.sendEmptyMessage(0);
		mutiHandler.handler2.sendEmptyMessage(0);
		mutiHandler.handler3.sendEmptyMessage(0);
		
	}
}
