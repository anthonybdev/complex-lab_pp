package Lab6.Command;

import Lab6.TrainCars.TrainCar;

import java.util.List;
import java.util.Scanner;

public class Diapazon implements Command {
    private Scanner scanner;

    public Diapazon(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(List<TrainCar> list) {
        System.out.print("Введіть діапазон : \n");
        int min =scanner.nextInt();
        int max = scanner.nextInt();
        int d=0;
        for (int i=0;i<list.size();i++) {
            if(list.get(i).getNumbPassengers()>=min &&
                    list.get(i).getNumbPassengers()<=max) {
                d++;
                System.out.print(list.get(i)+"\n");
            }else if(d==0){
                System.out.println("Немає вагонів в заданому діапазоні!");
            }
        }
    }
}
