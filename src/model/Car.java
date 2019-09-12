package model;

/**
 * An abstract class to represent the model Car to be inherited by other Classes.
 */
public class Car {
    protected int id; // The id of the car.
    protected String brand; // The brand of the car.
    protected String color; // The color of the car.
    protected String type; // The type of the car ( Cabrio, Family or Sport).
    protected int maxSpeed; // The maximum speed of the car.
    protected int maxCapacity; // The maximum capacity of the car.
    protected int currentFuel; // The current fuel of the car.
    protected int maxFuel; // The maximum fuel that the car can have.
    protected boolean startedEngine; // Whether the engine is started or not ( true / false ).
    protected boolean beingDriven; // Whether the car is being driven or not ( true / false ).
    protected boolean openedRoof; // Whether the roof is opened or not ( only for Cabrio ).

    /**
     * A constructor with no arguments.
     */
    public Car() {
        brand = "";
        color = "";
        type = "";
        maxSpeed = 0;
        maxCapacity = 0;
        currentFuel = 100;
        maxFuel = 100;
        startedEngine = false;
        beingDriven = false;
        openedRoof = false;
    }

    /**
     * A constructor with 4 arguments.
     *
     * @param brand       The car's brand.
     * @param color       The car's color.
     * @param maxSpeed    The car's maximum speed.
     * @param maxCapacity The car's maximum capacity.
     */
    public Car(String brand, String color, int maxSpeed, int maxCapacity) {
        this();
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
    }

    /**
     * An overridden method to show a more user-friendly representation of the car object.
     *
     * @return User-friendly representation of the car object.
     */
    @Override
    public String toString() {
        String txt = "ID: " + this.id + ". This  " + this.brand + " is a " + this.type + " car, colored " + this.color
                + " with fuel " + this.currentFuel + " / " + this.maxFuel
                + " and maximum speed " + this.maxSpeed + ".\n";
        if (startedEngine && beingDriven)
            txt += "Currently the car's engine is started and the car is being driven.\n";
        if (startedEngine && !beingDriven)
            txt += "Currently the car's engine is started and the car is standing still.\n";
        if (!startedEngine)
            txt += "Currently the car's engine is not started.\n";
        return txt;
    }

    /**
     * All the getters and setters.
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isOpenedRoof() {
        return openedRoof;
    }

    public void setOpenedRoof(boolean openedRoof) {
        this.openedRoof = openedRoof;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public boolean isStartedEngine() {
        return startedEngine;
    }

    public void setStartedEngine(boolean startedEngine) {
        this.startedEngine = startedEngine;
    }

    public boolean isBeingDriven() {
        return beingDriven;
    }

    public void setBeingDriven(boolean beingDriven) {
        this.beingDriven = beingDriven;
    }

    /**
     * A method to start the engine.
     * If there is not enough fuel or the car's engine is already started, nothing happens.
     */
    public void startEngine() {
        if (!this.startedEngine) {
            if (this.currentFuel >= 5) {
                System.out.println("Car's engine successfully started.");
                this.startedEngine = true;
            } else {
                System.out.println("Not enough fuel to start the car. Better refuel!");
            }
        } else {
            System.out.println("The engine is already started.");
        }
    }

    /**
     * A method to stop the engine.
     * If the car's engine hasn't been started, nothing happens.
     */
    public void stopEngine() {
        if (this.startedEngine) {
            this.startedEngine = false;
            System.out.println("Car's engine successfully stopped");
        } else {
            System.out.println("Car's engine is not started.");
        }
    }

    /**
     * A method to start driving the car.
     * If the engine hasn't been started or the car is already being driven, nothing happens.
     */
    public void driveCar() {
        if (this.startedEngine) {
            if (!this.beingDriven) {
                if (this.currentFuel >= 5) {
                    System.out.println("Successfully started driving the car.");
                    this.beingDriven = true;
                    this.currentFuel -= 5;
                } else {
                    System.out.println("Not enough fuel to start driving.");
                }
            } else {
                System.out.println("The car is already being driven.");
            }
        } else {
            System.out.println("The car's engine is not started yet.");
        }
    }

    /**
     * A method to stop driving the car.
     * If the car is not being driven right now or the engine is not started, nothing happens.
     */
    public void stopCar() {
        if (this.startedEngine) {
            if (this.beingDriven) {
                System.out.println("The car has successfully stopped driving.");
                this.beingDriven = false;
            } else {
                System.out.println("The car is not being driven right now.");
            }
        } else {
            System.out.println("The car's engine is not even started.");
        }
    }

    /**
     * A method to return the amount of fuel remaining.
     *
     * @return the amount of fuel left.
     */
    public int checkFuel() {
        return this.currentFuel;
    }

    /**
     * A method to simulate the refueling.
     */
    public void refuel() {
        this.currentFuel = this.maxFuel;
    }

    /**
     * A method to change the car's color.
     *
     * @param newColor The color to be changed to.
     */
    public void repaintCar(String newColor) {
        this.setColor(newColor);
    }
}
