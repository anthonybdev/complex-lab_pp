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

class DiapazonTest {
    private static ByteArrayOutputStream outputStream;

    private static TrainCar LuxurytrainCar;
    private static TrainCar CommontrainCar;
    private static TrainCar CoupetrainCar;

    @BeforeAll
    static void setUpAll() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LuxurytrainCar = new LuxuryTrainCar("Luxury",7,8);
        CommontrainCar = new CommonTrainCar("Common",3,35,36);
        CoupetrainCar = new CoupeTrainCar("Coupe",5,40,45);

    }

    @ParameterizedTest
    @ValueSource(strings = {"6 39"})
    void execute(String userInput) throws SQLException {
        List<TrainCar> anual= new ArrayList<>();
        Scanner scanner = new Scanner(userInput);
        Command diapazon = new Diapazon(scanner);

        anual.add(LuxurytrainCar);
        anual.add(CommontrainCar);
        anual.add(CoupetrainCar);

        diapazon.execute(anual);

        assertEquals("Введіть діапазон : \n"+"LuxuryTrainCar{Name=Luxury,ComfortLevel=7,NumbPassengers=8,NumbLuggage=0}\n"+
                "CommonTrainCar{Name=Common,ComfortLevel=3,NumbPassengers=35,NumbLuggage=36}\n",outputStream.toString());
    }

    @AfterAll
    static void tearDown(){
        System.setOut(System.out);
    }
}