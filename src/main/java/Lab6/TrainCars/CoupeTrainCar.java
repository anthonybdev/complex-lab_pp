package Lab6.TrainCars;

import java.util.Scanner;

public class CoupeTrainCar extends TrainCar {
    private int ComfortLevel;
    private int NumbPassengers;
    private int NumbLuggage;

    Scanner scanner = new Scanner(System.in);

    public CoupeTrainCar(String name,int ComforLevel,int NumbPassengers,int NumbLuggage  ){
        super(name);
        this.ComfortLevel=ComforLevel;
        this.NumbPassengers=NumbPassengers;
        this.NumbLuggage=NumbLuggage;
    }

    @Override
    public int getComfortLevel() { return ComfortLevel; }

    @Override
    public int getNumbPassengers() { return NumbPassengers; }

    @Override
    public int getNumbLuggage() { return NumbLuggage; }

    @Override
    public void setNumbPassengers(Scanner scanner) {
        System.out.print("Кількість пасажирів(mах = 45) : ");
        int numbPassengers = scanner.nextInt();

        if(numbPassengers <= 45)
            NumbPassengers = numbPassengers;
    }

    @Override
    public void setComfortLevel(Scanner scanner) {
        System.out.print("Рівень комфорту (mах = 7) : ");
        int comfortLevel = scanner.nextInt();
        if(comfortLevel <= 7)
            ComfortLevel = comfortLevel;
    }

    @Override
    public void setNumbLuggage(Scanner scanner) {
        System.out.print("Кількість багажу (mах = 45) : ");
        int numbCoupe = scanner.nextInt();
        if(numbCoupe <=45)
            NumbLuggage = numbCoupe;
    }

    @Override
    public String toString() {
        return "CoupeTrainCar{" +
                "Name=" + getName()+',' +
                "ComfortLevel=" + ComfortLevel + ',' +
                "NumbPassengers=" + NumbPassengers +',' +
                "NumbLuggage=" + NumbLuggage + '}';
    }

}
