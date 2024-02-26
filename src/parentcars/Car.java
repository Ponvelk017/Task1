package parentcars;

import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import util.Util;

public class Car {
	
	private final Logger logger = Logger.getLogger(Car.class.getName());
	
    private int yearOfMaking;
    private String type;
    private String engineType;

    public Car(String message) {
        System.out.println(message);
    }
    
    public int getYearOfMaking() {
        return yearOfMaking;
    }

    public void setYearOfMaking(int yearOfMaking){
        this.yearOfMaking = yearOfMaking;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InvalidInputException {
	Util.checkNull(type);
        this.type = type;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) throws InvalidInputException {
    	Util.checkNull(engineType);
        this.engineType = engineType;
    }

    public void maintenance(){
       logger.info("Car Under maintenance .");
    }
}
