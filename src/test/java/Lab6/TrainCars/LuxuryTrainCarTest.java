package Lab6.TrainCars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

class LuxuryTrainCarTest extends TestCase {
    static LuxuryTrainCar trainCar;
    static LuxuryTrainCar trainCar1;

    @BeforeAll
    static void start_testing(){
        trainCar = new LuxuryTrainCar("Luxury",10,4);
        trainCar1 = new LuxuryTrainCar("Luxury",15,9);
    }

    @Test
    void getComfortLevel() {
        assertEquals(10, trainCar.getComfortLevel());
    }

    @Test
    void getNumbPassengers() {
        assertEquals(4,trainCar.getNumbPassengers());
    }
    @Test
    void getNumbLuggage() {
        assertEquals(0,trainCar.getNumbLuggage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10"})
    void setNumbPassengers(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setNumbPassengers(scanner);
        assertEquals(10,trainCar1.getNumbPassengers());
    }

    @ParameterizedTest
    @ValueSource(strings = {"8"})
    void setComfortLevel(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setComfortLevel(scanner);
        assertEquals(8,trainCar1.getComfortLevel());
    }

    @ParameterizedTest
    @ValueSource(strings = {"7"})
    void setNumbLuggage(String userInput) {
        Scanner scanner = new Scanner(userInput);
        trainCar1.setNumbLuggage(scanner);
        assertEquals(0,trainCar1.getNumbLuggage());
    }
}