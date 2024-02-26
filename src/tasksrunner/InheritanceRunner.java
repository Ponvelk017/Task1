package tasksrunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import bird.ParrotMod;
import childcars.Scross;
import childcars.Swift;
import childcars.Xuv;
import inputcheck.InvalidInputException;
import parentcars.Car;

public class InheritanceRunner {

	private Logger logger = Logger.getLogger(InheritanceRunner.class.getName());

    public void taskRunner() {
        try {
            Car newCar = new Car("Inside Car class");
            Swift swift = new Swift("Inside Swift");
            swift.setSeats(4);
            swift.setAirBags(4);
            swift.setModel("Desier");
            swift.setColor("Red");
            swift.setType("swift");
            swift.setEngineType("12-Cylinder");
            swift.setYearOfMaking(2000);
            logger.info("Swift seates : " + swift.getSeats() + " Airbags : " + swift.getAirBags() + " Color : " + swift.getColor() + " EngineColor : " + swift.getModel() + " YearOfMaking : "+ swift.getYearOfMaking() + " EngineType : " + swift.getEngineType());
            Scross scross = new Scross("Inside Scross");
            scross.setSeats(6);
            scross.setAirBags(8);
            scross.setModel("Scross");
            scross.setColor("White");
            scross.setType("Scross");
            scross.setEngineType("16-Cylinder");
            scross.setYearOfMaking(2010);
            logger.info("scross seates : " + scross.getSeats() + " Airbags : " + scross.getAirBags() +" Color : " + scross.getColor() + " EngineColor : " + scross.getModel() + " YearOfMaking : "+ scross.getYearOfMaking() + " EngineType : " + scross.getEngineType());
            Xuv xuv = new Xuv();
            xuv.setSeats(6);
            xuv.setAirBags(8);
            xuv.setModel("XUV");
            xuv.setColor("Brown");
            xuv.setType("XUV");
            xuv.setEngineType("16-Cylinder");
            xuv.setYearOfMaking(2018);
            logger.info("scross seates : " + xuv.getSeats() + " Airbags : " + xuv.getAirBags() + " Color : " + xuv.getColor() + " EngineColor : " + xuv.getModel() + " YearOfMaking : " + xuv.getYearOfMaking()
                    + " EngineType : " + xuv.getEngineType());

            InheritanceRunner inRunner = new InheritanceRunner();
            inRunner.acceptsCarObject(swift); // swift
            inRunner.acceptsCarObject(scross); // scross
            inRunner.acceptsCarObject(xuv); // xuv

            inRunner.acceptsSwiftObject(swift); // swift
            // inRunner.acceptsSwiftObject(newCar); // error
            // inRunner.acceptsSwiftObject(scross);// error
            // inRunner.acceptsSwiftObject(xuv); // error

            scross.maintenance(); // Maruthi scross under Maintance
            Car scrossCar = new Scross("Inside Scross");
            scrossCar.maintenance(); // Maruthi scross under Maintance
            newCar.maintenance(); // car under Maintance
            swift.maintenance();// car under Maintance

            xuv = new Xuv(); // default constructor //
            xuv = new Xuv("String from main class"); // parameterized constructor

            // BridAbstract newBird = new BirdAbstract(); //compilation error ,cannot create
            // object for abstract classes
            ParrotMod newParrot = new ParrotMod();
            newParrot.fly(); // The bird flies
            newParrot.speak();// The bird speaks
            
        } catch (InvalidInputException e) {
        	logger.log(Level.INFO, "An Exception Occured", e);
        }
    }

    public void acceptsCarObject(Car newcar) {
        logger.info(newcar.getType());
    }

    public void acceptsSwiftObject(Swift newswift) {
        logger.info(newswift.getType());
    }
}
