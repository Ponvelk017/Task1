package bird;

import java.util.logging.Logger;

public class Duck extends Bird{
	private final Logger logger = Logger.getLogger(Duck.class.getName());
    public void fly(){
        logger.info("Inside th e fly method of duck class");
    }
}
