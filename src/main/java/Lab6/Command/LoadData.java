package Lab6.Command;

import Lab6.ConectionToDatabase.ConectionDatabase;
import Lab6.TrainCars.*;
import java.sql.*;
import java.util.*;


public class LoadData implements Command {


    public LoadData(Scanner scanner) {}

    @Override
    public void execute(List<TrainCar> list){

        ConectionDatabase conection = null;
        try {
            conection = new ConectionDatabase();
            String Type;
            int ComfortLevel;
            int Passenger;
            int Luggage;


            Statement statement = conection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TrainSpecification");

            int i = 0;
            while (resultSet.next()) {
                Type = resultSet.getString(2);
                ComfortLevel = resultSet.getInt(3);
                Passenger = resultSet.getInt(4);
                Luggage = resultSet.getInt(5);

                if(Type.equals("Luxury")) {
                    list.add(new LuxuryTrainCar(Type, ComfortLevel, Passenger));
                } else if(Type.equals(("Coupe"))) {
                    list.add(new CoupeTrainCar(Type, ComfortLevel, Passenger, Luggage));
                } else {
                    list.add(new CommonTrainCar(Type, ComfortLevel, Passenger, Luggage));
                }
                i++;
            }

            System.out.println("Додано вагонів: " + i);

            conection.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


