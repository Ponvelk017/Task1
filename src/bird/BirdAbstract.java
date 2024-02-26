package bird;

import java.util.logging.Logger;

public abstract class BirdAbstract {
	
	private final Logger logger = Logger.getLogger(BirdAbstract.class.getName());
	
    public void fly(){
        logger.info("The Bird flies");
    }

    public void speak(){
        logger.info("The bird Speakes ");
    }
    
}
