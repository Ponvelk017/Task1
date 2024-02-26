package tasksrunner;

import java.util.Scanner;
import java.util.logging.Logger;

import task.ExtendenThread;
import task.RunnableThread;

public class ThreadClassRunner {

	Logger logger = Logger.getLogger(ThreadClassRunner.class.getName());

	public void taskRunner() {

		try (Scanner scanner = new Scanner(System.in)) {
			int sleepTime = 60000;
//		logger.info("The name of the current Thread : " +Thread.currentThread().getName());
//		logger.info("The priority of the thread is :" + Thread.currentThread().getPriority());
//		logger.info("The State of the thread is :" + Thread.currentThread().getState());
//		ExtendenThread extendenObj =  new ExtendenThread(sleepTime);
//		extendenObj.setName("Extenden Thread");
//		extendenObj.start();
//		logger.info("The name of the current Thread : " +Thread.currentThread().getName());
//		logger.info("The priority of the thread is :" + Thread.currentThread().getPriority());
//		logger.info("The State of the thread is :" + Thread.currentThread().getState());
//		
//		RunnableThread runnableObj =  new RunnableThread(sleepTime);
//		Thread thread = new Thread(runnableObj , "Runnable Thread");
//		thread.start();
//		logger.info("The name of the current Thread : " +Thread.currentThread().getName());
//		logger.info("The priority of the thread is :" + Thread.currentThread().getPriority());
//		logger.info("The State of the thread is :" + Thread.currentThread().getState());
//			
			ExtendenThread extendenObj1 = new ExtendenThread(sleepTime);
			extendenObj1.setBreakPoint(2);
			extendenObj1.setName("Extenden Thread 1");
			extendenObj1.start();
			logger.info(extendenObj1.isAlive() + "");
			ExtendenThread extendenObj2 = new ExtendenThread(sleepTime);
			extendenObj2.setBreakPoint(2);
			extendenObj2.setName("Extenden Thread 2");
			extendenObj2.start();
			logger.info(extendenObj2.isAlive() + "");
			ExtendenThread extendenObj3 = new ExtendenThread(sleepTime);
			extendenObj3.setBreakPoint(2);
			extendenObj3.setName("Extenden Thread 3");
			extendenObj3.start();
			logger.info(extendenObj3.isAlive() + "");
			ExtendenThread extendenObj4 = new ExtendenThread(sleepTime);
			extendenObj4.setBreakPoint(2);
			extendenObj4.setName("Extenden Thread 2");
			extendenObj4.start();
			logger.info(extendenObj4.isAlive() + "");
			ExtendenThread extendenObj5 = new ExtendenThread(sleepTime);
			extendenObj5.setBreakPoint(2);
			extendenObj5.setName("Extenden Thread 5");
			extendenObj5.start();
			logger.info(extendenObj5.isAlive() + "");
			
			
			sleepTime = 25000;			
			RunnableThread runnableObj1 = new RunnableThread(sleepTime);
			runnableObj1.setBreakPoint(2);
			Thread thread1 = new Thread(runnableObj1, "Runnable Thread 1");
			thread1.start();
			logger.info(thread1.isAlive() + "");
			RunnableThread runnableObj2 = new RunnableThread(sleepTime);
			runnableObj2.setBreakPoint(2);
			Thread thread2 = new Thread(runnableObj2, "Runnable Thread 2");
			thread2.start();
			logger.info(thread2.isAlive() + "");
			RunnableThread runnableObj3 = new RunnableThread(sleepTime);
			runnableObj3.setBreakPoint(2);
			Thread thread3 = new Thread(runnableObj3, "Runnable Thread 3");
			thread3.start();
			logger.info(thread3.isAlive() + "");
			RunnableThread runnableObj4 = new RunnableThread(sleepTime);
			runnableObj4.setBreakPoint(2);
			Thread thread4 = new Thread(runnableObj4, "Runnable Thread 2");
			thread4.start();
			logger.info(thread4.isAlive() + "");
			RunnableThread runnableObj5 = new RunnableThread(sleepTime);
			runnableObj5.setBreakPoint(2);
			Thread thread5 = new Thread(runnableObj5, "Runnable Thread 5");
			thread5.start();
			logger.info(thread5.isAlive() + "");
		}
	}
}
