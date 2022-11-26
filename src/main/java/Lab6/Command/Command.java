package Lab6.Command;
import Lab6.TrainCars.TrainCar;

import java.util.List;

public interface Command {
    void execute(List<TrainCar> trainCarList);
}
