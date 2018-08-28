package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Тесты для ввода данных с проверкой вводимых пользователем значений.
 * @author vzamylin
 * @version 1
 * @since 29.08.2018
 */
public class ValidateInputTest {
    private final PrintStream stdOut = System.out; // Стандартный дефолтный вывод в консоль.
    private final ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream(); // Вывод в байтовый массив.

    /**
     * Установка вывода в байтовый массив.
     * Автоматически выполняется перед запуском каждого теста, но по сути это нужно только для тестов вывода на консоль.
     */
    @Before
    public void setByteArrayOut() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.byteArrayOut));
    }

    /**
     * Возврат стандартного вывода в консоль.
     * Автоматически выполняется после запуска каждого теста.
     */
    @After
    public void setStdOut() {
        System.setOut(this.stdOut);
        System.out.println("Execute after method");
    }

    /**
     * Проверка неправильного ввода.
     */
    @Test
    public void whenInvalidInput() {
        new ValidateInput(new StubInput(new String[]{"1", "0"})).ask("question", new int[]{0});
        assertThat(this.byteArrayOut.toString(), is(String.format("%s%s", "Предопределенное в заглушке значение не содержится в указанном списке.", System.lineSeparator())));
    }
}