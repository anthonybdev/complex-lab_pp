package Lab6.TrainCars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TrainCarTest {
    static CoupeTrainCar trainCar;
    static CoupeTrainCar trainCar1;

    @BeforeEach
    void setUp() {
        trainCar = new CoupeTrainCar("Coupe",7,30,45);
        trainCar1 = new CoupeTrainCar("Coupe",4,40,23);
    }

    @Test
    void setName() {
        trainCar.setName("CoupeTrain");
        assertEquals("CoupeTrain",trainCar.getName());
    }

    @Test
    void getName() {
        assertEquals("Coupe",trainCar1.getName());
    }
}