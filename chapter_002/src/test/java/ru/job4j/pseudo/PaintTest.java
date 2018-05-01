package ru.job4j.pseudo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты вывода фигур на консоль.
 * @author vzamylin
 * @version 2
 * @since 01.05.2018
 */
public class PaintTest {
    private final PrintStream stdOut = System.out; // Стандартный дефолтный вывод в консоль.
    private final ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); // Вывод в байтовый массив.

    /**
     * Установка вывода в байтовый массив (перед запуском каждого теста).
     */
    @Before
    public void setByteArrayOut() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.byteArrayOut));
    }

    /**
     * Возврат стандартного вывода в консоль (после запуска каждого теста).
     */
    @After
    public void setStdOut() {
        System.setOut(this.stdOut);
        System.out.println("Execute after method");
    }

    /**
     * Проверка вывода треугольника.
     */
    @Test
    public void whenPrintTriangle() {
        new Paint().print(new Triangle());
        assertThat(
                this.byteArrayOut.toString(),
                is(new StringJoiner(System.lineSeparator())
                        .add("  +  ")
                        .add(" + + ")
                        .add("+++++")
                        .add("")
                        .toString()
                )
        );

    }

    /**
     * Проверка вывода квадрата.
     */
    @Test
    public void whenPrintSquare() {
        new Paint().print(new Square());
        assertThat(
                this.byteArrayOut.toString(),
                is(new StringJoiner(System.lineSeparator())
                        .add("++++")
                        .add("+  +")
                        .add("+  +")
                        .add("++++")
                        .add("")
                        .toString()
                )
        );

    }
}