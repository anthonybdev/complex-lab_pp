package Lab6.Command;

import Lab6.TrainCars.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortTrainCarTest {
    private static ByteArrayOutputStream stream1;
    private static Scanner scanner;

    private static List<TrainCar>expected;
    private static List<TrainCar>actual;

    private static TrainCar LuxurytrainCar1;
    private static TrainCar LuxurytrainCar2;
    private static TrainCar CommontrainCar;
    private static TrainCar CoupetrainCar;

    @BeforeAll
    static void setUp() {
        LuxurytrainCar1 = new LuxuryTrainCar("Luxury",10,8);
        LuxurytrainCar2 = new LuxuryTrainCar("Luxury",7,3);
        CommontrainCar = new CommonTrainCar("Common",3,35,36);
        CoupetrainCar = new CoupeTrainCar("Coupe",5,40,45);

        expected = new ArrayList<>();
        actual = new ArrayList<>();

        stream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream1));
    }

    @Test
    void SortComandsTest() {
        SortTrainCar sortComands = new SortTrainCar(scanner);
        sortComands.SortComands();

        assertEquals("1- Cортування в порядку зростання рівня комфорту\n" +
                "2- Cортування в порядку спадання рівня комфорту\n"+
                "3- Cортування в порядку зростання кількості пасажирів\n"+
                "4- Cортування в порядку спадання кількості пасажирів\n",stream1.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void execute1(String userInput) throws SQLException {

        TrainCar LuxurytrainCar1 = new LuxuryTrainCar("Luxury",10,8);
        TrainCar LuxurytrainCar2 = new LuxuryTrainCar("Luxury",7,3);
        TrainCar CommontrainCar = new CommonTrainCar("Common",3,35,36);
        TrainCar CoupetrainCar = new CoupeTrainCar("Coupe",5,40,45);

        scanner = new Scanner(userInput);
        Command sort = new SortTrainCar(scanner);
        expected.add(LuxurytrainCar1);
        expected.add(LuxurytrainCar2);
        expected.add(CoupetrainCar);
        expected.add(CommontrainCar);

        actual.add(LuxurytrainCar2);
        actual.add(CommontrainCar);
        actual.add(LuxurytrainCar1);
        actual.add(CoupetrainCar);

        sort.execute(actual);
        assertEquals(expected,actual);

        expected.clear();
        actual.clear();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void execute2(String userInput) throws SQLException {
        TrainCar LuxurytrainCar1 = new LuxuryTrainCar("Luxury",10,8);
        TrainCar LuxurytrainCar2 = new LuxuryTrainCar("Luxury",7,3);
        TrainCar CommontrainCar = new CommonTrainCar("Common",3,35,36);
        TrainCar CoupetrainCar = new CoupeTrainCar("Coupe",5,40,45);

        scanner = new Scanner(userInput);
        Command sort = new SortTrainCar(scanner);
        expected.add(LuxurytrainCar2);
        expected.add(LuxurytrainCar1);
        expected.add(CommontrainCar);
        expected.add(CoupetrainCar);

        actual.add(CommontrainCar);
        actual.add(LuxurytrainCar1);
        actual.add(LuxurytrainCar2);
        actual.add(CoupetrainCar);

        sort.execute(actual);
        assertEquals(expected,actual);
    }

    @AfterAll
    static void tearDown(){
        System.setOut(System.out);
    }
}