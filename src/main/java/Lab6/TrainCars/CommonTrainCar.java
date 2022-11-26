package Lab6.TrainCars;

import java.util.Scanner;

public class CommonTrainCar extends TrainCar {
    private int ComfortLevel;
    private int NumbPassengers;
    private int NumbLuggage;

    Scanner scanner = new Scanner(System.in);

    public CommonTrainCar(String name,int ComforLevel,int NumbPassengers,int NumbLuggage  ){
        super(name);
        this.ComfortLevel=ComforLevel;
        this.NumbPassengers=NumbPassengers;
        this.NumbLuggage=NumbLuggage;
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
    public void setNumbPassengers(Scanner scanner) {
        System.out.print("Введіть Кількість пасажирів(mах = 60),");
        System.out.print("Якщо к-сть > 40,Рівень комфорту(-2) : ");
        int numbPassengers = scanner.nextInt();

        if(numbPassengers <= 60)
            NumbPassengers = numbPassengers;
        if (numbPassengers <=40)
            ComfortLevel -=2;
    }

    @Override
    public void setComfortLevel(Scanner scanner) {
        System.out.print("Рівень комфорту (mах = 5) : ");
        int comfortLevel = scanner.nextInt();
        if(comfortLevel <= 5)
            ComfortLevel = comfortLevel;
    }


    @Override
    public int getNumbLuggage() {
        return NumbLuggage;
    }

    @Override
    public void setNumbLuggage(Scanner scanner) {
        System.out.print("Кількість багажу (mах = 60),Якщо к-сть > 40,Рівень комфорту(-1) : ");
        int numbCommon = scanner.nextInt();
        if(numbCommon <=60)
            NumbLuggage = numbCommon;
        if (numbCommon>40){
            ComfortLevel -- ;
        }
    }

    @Override
    public String toString() {
        return "CommonTrainCar{" +
                "Name=" + getName()+',' +
                "ComfortLevel=" + ComfortLevel + ',' +
                "NumbPassengers=" + NumbPassengers +',' +
                "NumbLuggage=" + NumbLuggage +
                '}';
    }

}
