package task;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendenThread extends Thread {

	private Logger logger = Logger.getLogger(ExtendenThread.class.getName());

//	public void run() {
//		logger.info("The name of the Thread is : " +getName());
//		logger.info("The priority of the thread is :" + getPriority());
//		logger.info("The State of the thread is :" + getState());
//	}

	private int sleepTime;
	private int breakPoint;

	public ExtendenThread(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	public void setBreakPoint(int breakPoint) {
		this.breakPoint = breakPoint;
	}

	public void run() {
		try {
			logger.info("Going to sleep : " + getName());
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
			logger.info("After sleep : " + getName());
			logger.info(Thread.currentThread().isAlive()+"");
		} catch (InterruptedException e) {
			logger.log(Level.INFO, "An Exception occured in Thread", e);
		}

	}
}
