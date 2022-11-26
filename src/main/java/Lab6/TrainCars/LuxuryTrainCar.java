package Lab6.TrainCars;

import java.util.Scanner;

public class LuxuryTrainCar extends TrainCar {
    private int ComfortLevel;
    private int NumbPassengers;

    public LuxuryTrainCar(String name,int ComforLevel,int NumbPassengers){
        super(name);
        this.ComfortLevel=ComforLevel;
        this.NumbPassengers=NumbPassengers;
    }

    @Override
    public int getComfortLevel() {
        return ComfortLevel;
    }

    @Override
    public int getNumbPassengers() {
        return NumbPassengers;
    }

    @Override
    public int getNumbLuggage() {return 0;}

    @Override
    public void setNumbPassengers(Scanner scanner) {
        System.out.print("Кількість пасажирів(mах = 10) : ");
        int numbPassengers = scanner.nextInt();
        if(numbPassengers <= 10)
            NumbPassengers = numbPassengers;
    }

    @Override
    public void setComfortLevel(Scanner scanner)
    {
        System.out.print("Рівень комфорту (mах = 15) : ");
        int comfortLevel = scanner.nextInt();
        if(comfortLevel <= 15)
            ComfortLevel = comfortLevel;
    }

    @Override
    public void setNumbLuggage(Scanner scanner) {

    }

    @Override
    public String toString() {
        return "LuxuryTrainCar{" +
                "Name=" + getName()+',' +
                "ComfortLevel=" + ComfortLevel + ',' +
                "NumbPassengers=" + NumbPassengers +',' +
                "NumbLuggage=" + 0 + "}";
    }
}
