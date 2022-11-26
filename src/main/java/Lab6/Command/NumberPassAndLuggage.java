package Lab6.Command;

import Lab6.TrainCars.TrainCar;

import java.util.List;
import java.util.Scanner;

public class NumberPassAndLuggage implements Command {

    private Scanner scanner;

    public NumberPassAndLuggage (Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(List<TrainCar>list) {
        System.out.print("Кількість пасажирів введіть (1)\n" +
                "Кількість багажу введіть (2) : ");

        int j = scanner.nextInt();
        int sum=0;
        for (int i =0;i< list.size();i++) {
            if (j == 1)
                sum += list.get(i).getNumbPassengers();
            else if (j == 2)
                sum += list.get(i).getNumbLuggage();
        }
        if (j==1)
            System.out.print("Кількість пасажирів = " + sum+"\n");
        else if(j==2)
            System.out.print("Кількість багажу = " + sum+"\n");
    }
}
