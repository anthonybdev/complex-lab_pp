package Lab6.Command;

import Lab6.TrainCars.CommonTrainCar;
import Lab6.TrainCars.LuxuryTrainCar;
import Lab6.TrainCars.TrainCar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddTrainCarTest {
    static List<TrainCar> ListTrainCars;

   @BeforeAll
   static void start_testing() {
       ListTrainCars = new ArrayList<>();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void execute1(String userInput ) throws SQLException {

        Scanner scanner = new Scanner(userInput);
        Command command = new AddTrainCar(scanner);

        TrainCar trainCar = new LuxuryTrainCar("Luxury",10,8);

        List<TrainCar> NewListTrainCars= new ArrayList<>();
        NewListTrainCars.add(trainCar);

        command.execute(ListTrainCars);

        assertEquals(NewListTrainCars.get(0).getName(),ListTrainCars.get(0).getName());
        assertEquals(NewListTrainCars.get(0).getComfortLevel(),ListTrainCars.get(0).getComfortLevel());
        assertEquals(NewListTrainCars.get(0).getNumbPassengers(),ListTrainCars.get(0).getNumbPassengers());
        assertEquals(NewListTrainCars.get(0).getNumbLuggage(),ListTrainCars.get(0).getNumbLuggage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void execute2(String userInput ) throws SQLException {
        Scanner scanner = new Scanner(userInput);
        Command command = new AddTrainCar(scanner);

        TrainCar trainCar = new CommonTrainCar("Common",3,35,39);

        List<TrainCar> NewListTrainCars= new ArrayList<>();
        NewListTrainCars.add(trainCar);


        command.execute(ListTrainCars);

        assertEquals(NewListTrainCars.get(0).getName(),ListTrainCars.get(1).getName());
        assertEquals(NewListTrainCars.get(0).getComfortLevel(),ListTrainCars.get(1).getComfortLevel());
        assertEquals(NewListTrainCars.get(0).getNumbPassengers(),ListTrainCars.get(1).getNumbPassengers());
        assertEquals(NewListTrainCars.get(0).getNumbLuggage(),ListTrainCars.get(1).getNumbLuggage());
    }
}