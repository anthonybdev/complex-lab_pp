package Lab6.Command;
import Lab6.TrainCars.TrainCar;

import java.util.List;
import java.util.Scanner;

public class DeleteTrainCar implements Command {
    private Scanner scanner;

    public DeleteTrainCar(Scanner scanner) {
        this.scanner=scanner;
    }

    @Override
    public void execute(List<TrainCar> list) {
        System.out.print("Виберіть вагон який хочете видалити :");
        int elem = scanner.nextInt();
        if (elem >= list.size()){
            System.out.println("Вагону з таким номером немає!");
            return;
        }
        list.remove(elem);
        System.out.println("Вагон видалено!");


    }
}