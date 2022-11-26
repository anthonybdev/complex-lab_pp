package Lab6.TrainCars;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

class CommonTrainCarTest extends TestCase {
    static CommonTrainCar trainCar;
    static CommonTrainCar trainCar1;
    static CommonTrainCar trainCar2;

    @BeforeAll
    static void start_testing(){
        trainCar = new CommonTrainCar("Common",5,35,20);
        trainCar1 = new CommonTrainCar("Common",4,39,39);
        trainCar2 = new CommonTrainCar("Common",5,14,9);
    }

    @Test
    void getComfortLevel() {
        assertEquals(5, trainCar.getComfortLevel());
    }

    @Test
    void getNumbPassengers() {
        assertEquals(35,trainCar.getNumbPassengers());
    }
    @Test
    void getNumbLuggage() {
        assertEquals(20,trainCar.getNumbLuggage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"70"})
    void setNumbPassengers(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setNumbPassengers(scanner);
        assertEquals(39,trainCar1.getNumbPassengers());
    }

    @ParameterizedTest
    @ValueSource(strings = {"4"})
    void setComfortLevel(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setComfortLevel(scanner);
        assertEquals(4,trainCar1.getComfortLevel());
    }

    @ParameterizedTest
    @ValueSource(strings = {"42"})
    void setNumbLuggage(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar2.setNumbLuggage(scanner);
        assertEquals(42,trainCar2.getNumbLuggage());
        assertEquals(4,trainCar2.getComfortLevel());
    }
}