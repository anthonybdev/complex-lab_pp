package Lab6.MenuProgram;

import Lab6.Command.*;
import Lab6.Logger.Loggers;
import Lab6.TrainCars.TrainCar;

import java.sql.SQLException;
import java.util.*;

public class Menu {
    private List<TrainCar> trainCar;
    private Map<String,Command> menuItems;
    private Loggers log = new Loggers();

    private Scanner scanner = new Scanner(System.in);;

    public Menu(){
        menuItems = new LinkedHashMap<>();
        trainCar = new ArrayList<>();

        menuItems.put("Add",new AddTrainCar(scanner));
        menuItems.put("Print",new PrintTrainCar());
        menuItems.put("ChangeSpecification",new ChangeSpecification(scanner));
        menuItems.put("Number",new NumberPassAndLuggage(scanner));
        menuItems.put("Sort",new SortTrainCar(scanner));
        menuItems.put("Delete",new DeleteTrainCar(scanner));
        menuItems.put("Diapazon",new Diapazon(scanner));
        menuItems.put("Load",new LoadData(scanner));

    }

    public void menu(){
        System.out.print("Список команд\n");
        System.out.print("Add - якщо хочете добавити вагон до потяга\n");
        System.out.print("Print - якщо хочете вивести вагони потяга\n");
        System.out.print("ChangeSpecification - якщо хочете змінити характеристики вагона\n");
        System.out.print("Number - якщо хочете вивести кількість пасажирів або багажу\n");
        System.out.print("Sort - якщо хочете відсортувати вагони\n");
        System.out.print("Delete - якщо хочете видалити вагон\n");
        System.out.print("Diapazon - якщо хочете вивести вагони в діапазоні кількості пасажирів\n");
        System.out.print("Load - якщо хочете завантажити дані з БД\n");
        System.out.print("exit - якщо хочете закінчитити виконання\n");
    }

    public void MainMenu() {
        System.out.println("\nВведіть help - щоб побачити список команд!");

        while(true) {
            String command = scanner.nextLine();
            Command menuItem = menuItems.get(command);
            if(menuItem!=null){
                log.LogInfo("Ми викликали команду - "+command);
                menuItem.execute(trainCar);
            }

            if ("help".equals(command)) {
                log.LogInfo("Ми викликали команду - help");
                menu();
            }
            if ("exit".equals(command)) {
                log.LogInfo("Ми викликали команду - exit");
                return;
            }
        }
    }
}
