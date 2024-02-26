package task;

import inputcheck.InvalidInputException;
import util.Util;

public class Circle {
	
	private String formula;
	private int radius;
	
	public Circle (){
	}
	
	public Circle (String input1 , int input2) throws InvalidInputException {
		Util.checkNull(input1);
		this.formula = input1;
		this.radius = input2;
	}
	
	public String getFormula() {
		return formula;
	}
	
	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int inputInteger) {
		this.radius = inputInteger;
	}
	
	public String toString() {
		return formula+" "+radius;
	}
	
}
