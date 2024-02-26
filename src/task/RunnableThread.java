package task;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThread implements Runnable {

	private Logger logger = Logger.getLogger(RunnableThread.class.getName());

//	public void run() {
//		logger.info("The name of the Thread is : " + Thread.currentThread().getName());
//		logger.info("The priority of the thread is :" + Thread.currentThread().getPriority());
//		logger.info("The State of the thread is :" + Thread.currentThread().getState());
//	}
	
	private int sleepTime;
	private int breakPoint;

	public RunnableThread(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	public void setBreakPoint(int breakPoint) {
		this.breakPoint = breakPoint;
	}
	
	public void run() {
		try {
			logger.info("Going to sleep : " + Thread.currentThread().getName());
			int loopCount = 0;
			while (loopCount < breakPoint) {
				loopCount++;
				Thread.sleep(1*30*1000);
				ThreadMXBean threadDump = ManagementFactory.getThreadMXBean();
				long[] threadId = threadDump.getAllThreadIds();
				for(long individualId : threadId) {
					ThreadInfo threadInfo = threadDump.getThreadInfo(individualId);
					System.out.println(threadInfo+"");
				}
			}
			logger.info("After sleep : " + Thread.currentThread().getName());
		} 
		catch (InterruptedException e) {
			logger.log(Level.INFO, "An Exception occured in Thread", e);
		}
	}
}
