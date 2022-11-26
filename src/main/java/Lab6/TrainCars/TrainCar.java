package Lab6.TrainCars;

import java.util.Scanner;

public abstract class TrainCar {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TrainCar(String name) {
        this.name = name;
    }

    public abstract int getComfortLevel();
    public abstract int getNumbPassengers();
    public abstract int getNumbLuggage();
    public abstract void setComfortLevel(Scanner scanner);
    public abstract void setNumbPassengers(Scanner scanner);
    public abstract void setNumbLuggage(Scanner scanner);
}
