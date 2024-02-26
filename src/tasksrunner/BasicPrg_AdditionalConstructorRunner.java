package tasksrunner;

import java.util.logging.Logger;

import task.BasicProgramming_AdditionalConstructor;

public class BasicPrg_AdditionalConstructorRunner {
	
	private Logger logger = Logger.getLogger(BasicPrg_AdditionalConstructorRunner.class.getName());	

	public void taskTunner() {
		BasicProgramming_AdditionalConstructor additionalConstructor = new BasicProgramming_AdditionalConstructor ("Hello Java");
		logger.info(additionalConstructor.toString());
	}
}
