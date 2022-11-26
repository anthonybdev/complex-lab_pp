package Lab6.Command;

import Lab6.TrainCars.TrainCar;

import java.util.List;
import java.util.Scanner;

public class ChangeSpecification implements Command {
    private Scanner scanner;

    public ChangeSpecification(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(List<TrainCar> list) {
        System.out.println("Заміна параметрів");

        if (list.size()==0)
            return;

        while (true){
            System.out.print("Виберіть вагон (для завершення (-1) : ");
            int i = scanner.nextInt();
            if (i==(-1)) {
                System.out.println("Параметри змінено!");
                break;
            }
            list.get(i).setComfortLevel(scanner);
            list.get(i).setNumbPassengers(scanner);
            list.get(i).setNumbLuggage(scanner);

        }
    }
}
