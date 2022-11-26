package Lab6.MenuProgram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void menu(){
        Menu m = new Menu();
        m.menu();
        assertEquals("Список команд\n"+
                "Add - якщо хочете добавити вагон до потяга\n"+
                "Print - якщо хочете вивести вагони потяга\n"+
                "ChangeSpecification - якщо хочете змінити характеристики вагона\n"+
                "Number - якщо хочете вивести кількість пасажирів або багажу\n"+
                "Sort - якщо хочете відсортувати вагони\n"+
                "Delete - якщо хочете видалити вагон\n"+
                "Diapazon - якщо хочете вивести вагони в діапазоні кількості пасажирів\n"+
                "Load - якщо хочете завантажити дані з БД\n"+
                "exit - якщо хочете закінчитити виконання\n",outputStream.toString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }
}