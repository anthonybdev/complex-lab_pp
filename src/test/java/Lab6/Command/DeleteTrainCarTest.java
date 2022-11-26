package Lab6.Command;

import Lab6.TrainCars.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DeleteTrainCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void execute(String userInput) throws SQLException {
        List<TrainCar> expected = new ArrayList<>();
        List<TrainCar> anual = new ArrayList<>();
        TrainCar LuxurytrainCar = new LuxuryTrainCar("Luxury",10,8);
        TrainCar CommontrainCar = new CommonTrainCar("Common",3,35,36);

        expected.add(LuxurytrainCar);

        anual.add(LuxurytrainCar);
        anual.add(CommontrainCar);
        Scanner scanner = new Scanner(userInput);
        DeleteTrainCar deleteTrainCar = new DeleteTrainCar(scanner);
        deleteTrainCar.execute(anual);
        assertEquals(expected,anual);

    }
}