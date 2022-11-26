package Lab6.Command;
import Lab6.ConectionToDatabase.ConectionDatabase;
import Lab6.TrainCars.*;
import java.sql.*;
import java.util.*;


public class AddTrainCar implements Command {

    private Scanner scanner;

    public AddTrainCar(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(List<TrainCar> list){

        ConectionDatabase conection = null;
        try {
            conection = new ConectionDatabase();
            String[] Type = new String[3];
            int[] ComfortLevel = new int[3];
            int[] Luggage = new int[3];
            int[] Passenger = new int[3];

            Statement statement = conection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TrainDefaultSpecs");

            int i = 0;
            while (resultSet.next()) {
                Type[i] = resultSet.getString(2);
                ComfortLevel[i] = resultSet.getInt(3);
                Passenger[i] = resultSet.getInt(4);
                Luggage[i] = resultSet.getInt(5);
                i++;
            }

            System.out.println("Виберіть вагон:\n1-Luxury\n2-Coupe\n3-Common");

            int c = scanner.nextInt();
            if (c == 1) {
                list.add(new LuxuryTrainCar(Type[0], ComfortLevel[0], Passenger[0]));
            } else if (c == 2)
                list.add(new CoupeTrainCar(Type[1], ComfortLevel[1], Passenger[1], Luggage[1]));
            if (c == 3)
                list.add(new CommonTrainCar(Type[2], ComfortLevel[2], Passenger[2], Luggage[2]));
            System.out.println("Вагон додано!");

            conection.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

