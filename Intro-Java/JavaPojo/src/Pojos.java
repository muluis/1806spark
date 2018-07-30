

public abstract class Pojos {

private String modelNumber;
private int numberOfWheels;
private boolean isActive;
	
public abstract void move();

public Pojos() {};

public Pojos(String modelNumber, int numberOfWheels, boolean isActive) {
	super();
	this.modelNumber = modelNumber;
	this.numberOfWheels = numberOfWheels;
	this.isActive = isActive;
}

public String getModelNumber() {
	return modelNumber;
}

public void setModelNumber(String modelNumber) {
	this.modelNumber = modelNumber;
}

public int getNumberOfWheels() {
	return numberOfWheels;
}

public void setNumberOfWheels(int numberOfWheels) {
	this.numberOfWheels = numberOfWheels;
}

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
};

}

