package Lab6.Command;

import Lab6.TrainCars.TrainCar;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortTrainCar implements Command {
    private Scanner scanner;
    public SortTrainCar (Scanner scanner) {
        this.scanner = scanner;
    }

    private static Comparator SortList(int i )
    {
        Comparator<TrainCar> comparator = new Comparator<TrainCar>() {
            int com=0;
            @Override
            public int compare(TrainCar max, TrainCar min) {
                switch (i) {
                    case 1: {
                        com = max.getComfortLevel() - min.getComfortLevel();
                        break;
                    }
                    case 2: {
                        com = min.getComfortLevel() - max.getComfortLevel();
                        break;
                    }
                    case 3: {
                        com = max.getNumbPassengers() - min.getNumbPassengers();
                        break;
                    }
                    case 4: {
                        com = min.getNumbPassengers() - max.getNumbPassengers();
                        break;
                    }
                    default:{
                        System.out.println("Cортування не відбулося!");
                        break;
                    }

                }
                return com;
            }
        };
        return comparator;

    }

    public void SortComands(){
        System.out.print("1- Cортування в порядку зростання рівня комфорту\n");
        System.out.print("2- Cортування в порядку спадання рівня комфорту\n");
        System.out.print("3- Cортування в порядку зростання кількості пасажирів\n");
        System.out.print("4- Cортування в порядку спадання кількості пасажирів\n");
    }

    @Override
    public void execute(List<TrainCar> list) {
        SortComands();
        int i =scanner.nextInt();
        Comparator comparator = SortList(i);
        list.sort(comparator);
        System.out.println("Вагони відсортовано!");
        if (i>5)
            System.out.println("Команди з таким номером немає!");
    }

}
