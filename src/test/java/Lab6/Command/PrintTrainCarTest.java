package Lab6.Command;

import Lab6.TrainCars.*;
import org.junit.*;


import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class PrintTrainCarTest {
    private static ByteArrayOutputStream stream1;

    @Before
    public void setUp(){
        stream1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream1));
    }

    @Test
    public void executeTest1() {
        List<TrainCar> trainCars1= new ArrayList<>();
        PrintTrainCar print = new PrintTrainCar();
        print.execute(trainCars1);

        assertEquals("Вагонів немає!!!\n",stream1.toString());
    }

    @Test
    public void executeTest2() {
        List<TrainCar> trainCars = new ArrayList<>();

        TrainCar LuxurytrainCar = new LuxuryTrainCar("Luxury",10,8);
        TrainCar CommontrainCar = new CommonTrainCar("Common",3,35,36);

        trainCars.add(LuxurytrainCar);
        trainCars.add(CommontrainCar);

        PrintTrainCar print = new PrintTrainCar();
        print.execute(trainCars);

        assertEquals("1) LuxuryTrainCar{Name=Luxury,ComfortLevel=10,NumbPassengers=8,NumbLuggage=0}\n"+
                "2) CommonTrainCar{Name=Common,ComfortLevel=3,NumbPassengers=35,NumbLuggage=36}\n",stream1.toString());

    }

    @After
    public void tearDown(){
        System.setOut(System.out);
        try {
            stream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}