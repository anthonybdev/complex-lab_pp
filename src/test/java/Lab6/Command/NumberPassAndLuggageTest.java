package Lab6.Command;

import Lab6.TrainCars.CommonTrainCar;
import Lab6.TrainCars.CoupeTrainCar;
import Lab6.TrainCars.LuxuryTrainCar;
import Lab6.TrainCars.TrainCar;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NumberPassAndLuggageTest {
    private static ByteArrayOutputStream outputStream;

    private static List<TrainCar>anual;
    private static TrainCar LuxurytrainCar;
    private static TrainCar CommontrainCar;
    private static TrainCar CoupetrainCar;

    private static Scanner scanner;

    @BeforeAll
    static void setUpAll() {
        LuxurytrainCar = new LuxuryTrainCar("Luxury",7,3);
        CommontrainCar = new CommonTrainCar("Common",3,35,36);
        CoupetrainCar = new CoupeTrainCar("Coupe",5,40,45);
        anual = new ArrayList<>();

        anual.add(LuxurytrainCar);
        anual.add(CommontrainCar);
        anual.add(CoupetrainCar);
    }

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void executeTest1(String userInput) {

        scanner = new Scanner(userInput);
        NumberPassAndLuggage numb = new NumberPassAndLuggage(scanner);
        numb.execute(anual);

        assertEquals("Кількість пасажирів введіть (1)\n" +
                "Кількість багажу введіть (2) : " + "Кількість пасажирів = 78\n",outputStream.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2"})
     void executeTest2(String userInput) {

        scanner = new Scanner(userInput);
        NumberPassAndLuggage numb = new NumberPassAndLuggage(scanner);
        numb.execute(anual);

        assertEquals("Кількість пасажирів введіть (1)\n" +
                "Кількість багажу введіть (2) : " + "Кількість багажу = 81\n",outputStream.toString());
    }

    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(System.out);
        outputStream.close();
    }
}