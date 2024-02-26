package bird;

import java.util.logging.Logger;

public abstract class Bird {
	private final Logger logger = Logger.getLogger(Bird.class.getName());

    protected abstract void fly();
    public void speak(){
        logger.info("Inside the speak method of Bird class");
    }
    
}
