package org.pb.history;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {

	public static void main(String[] args) {
		
		new Timer().schedule(new MyTimerTask(),4000);
		
		while(true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("bombing!");
		new Timer().schedule(new MyTimerTask(), 2000);
	}
	
};
