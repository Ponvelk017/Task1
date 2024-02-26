
package childcars;

import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import parentcars.Car;
import util.Util;

public class Scross extends Car {
	
	private final Logger logger = Logger.getLogger(Scross.class.getName());

	private int seats;
	private int airBags;
	private String model;
	private String color;

	public Scross(String message) {
		super(message);
		System.out.println(message);
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAirBags() {
		return airBags;
	}

	public void setAirBags(int airBags) {
		this.airBags = airBags;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws InvalidInputException {
		Util.checkNull(model);
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) throws InvalidInputException {
		Util.checkNull(color);
		this.color = color;
	}

	public void maintenance() {
		logger.info("Maruthi scross Under maintenance .");
	}
}
