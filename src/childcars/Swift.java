package childcars;

import util.Util;
import inputcheck.InvalidInputException;
import parentcars.Car;

public class Swift extends Car {

    private int seats;
    private int airBags;
    private String model;
    private String color;

    public Swift(String message){
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

}
