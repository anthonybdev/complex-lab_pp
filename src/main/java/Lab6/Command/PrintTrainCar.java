package Lab6.Command;

import Lab6.TrainCars.TrainCar;

import java.util.List;

public class PrintTrainCar implements Command {

    public PrintTrainCar() {
    }

    @Override
    public void execute(List<TrainCar> list) {
        if (list.size() == 0)
            System.out.print("Вагонів немає!!!\n");

        for (int i = 0; i < list.size(); i++)
            System.out.print(i + 1 + ")" + " " + list.get(i)+"\n");
    }
}
