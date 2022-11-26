package Lab6.TrainCars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CoupeTrainCarTest {

    static CoupeTrainCar trainCar;
    static CoupeTrainCar trainCar1;

    @BeforeAll
    static void start_testing(){
        trainCar = new CoupeTrainCar("Coupe",7,30,45);
        trainCar1 = new CoupeTrainCar("Coupe",4,40,23);
    }

    @Test
    void getComfortLevel() {
        assertEquals(7, trainCar.getComfortLevel());
    }

    @Test
    void getNumbPassengers() {
        assertEquals(30,trainCar.getNumbPassengers());
    }
    @Test
    void getNumbLuggage() {
        assertEquals(45,trainCar.getNumbLuggage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"50"})
    void setNumbPassengers(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setNumbPassengers(scanner);
        assertEquals(40,trainCar1.getNumbPassengers());
    }

    @ParameterizedTest
    @ValueSource(strings = {"42"})
    void setComfortLevel(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setComfortLevel(scanner);
        assertEquals(4,trainCar1.getComfortLevel());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10"})
    void setNumbLuggage(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setNumbLuggage(scanner);
        assertEquals(10,trainCar1.getNumbLuggage());
    }
}