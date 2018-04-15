package ru.job4j.pseudo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты вывода фигур на консоль.
 * @author vzamylin
 * @version 1
 * @since 15.04.2018
 */
public class PaintTest {

    /**
     * Проверка вывода треугольника.
     */
    @Test
    public void whenPrintTriangle() {
        // Запоминаем ссылку на текущий стандартный поток вывода в консоль и переопределяем его на вывод в байтовый массив.
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            // Выводим треугольник
            new Paint().print(new Triangle());
            // Проверяем результат
            assertThat(
                    out.toString(),
                    is(new StringJoiner(System.lineSeparator())
                            .add("  +  ")
                            .add(" + + ")
                            .add("+++++")
                            .add("")
                            .toString()
                    )
            );
        } finally {
            // Возвращаем стандартный поток вывода в консоль
            System.setOut(stdOut);
        }
    }

    /**
     * Проверка вывода квадрата.
     */
    @Test
    public void whenPrintSquare() {
        // Запоминаем ссылку на текущий стандартный поток вывода в консоль и переопределяем его на вывод в байтовый массив.
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            // Выводим квадрат
            new Paint().print(new Square());
            // Проверяем результат
            assertThat(
                    out.toString(),
                    is(new StringJoiner(System.lineSeparator())
                            .add("++++")
                            .add("+  +")
                            .add("+  +")
                            .add("++++")
                            .add("")
                            .toString()
                    )
            );
        } finally {
            // Возвращаем стандартный поток вывода в консоль
            System.setOut(stdOut);
        }
    }
}