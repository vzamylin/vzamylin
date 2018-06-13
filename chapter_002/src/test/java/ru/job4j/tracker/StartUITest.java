package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты пользовательского интерфейса системы заявок (Tracker).
 * @author vzamylin
 * @version 2
 * @since 29.05.2018
 */
public class StartUITest {
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
     * Проверка добавления заявки.
     */
    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        // Выбрать в меню добавление заявки ("0"), ввести ее имя, описание и выйти из программы ("6")
        new StartUI(new StubInput(new String[]{"0", "name", "desc", "6"}), tracker).init();
        // Проверить результат добавления заявки
        Item[] trackerContent = tracker.findAll();
        assertThat(trackerContent.length, is(1));
        assertThat(trackerContent[0].getName(), is("name"));
        assertThat(trackerContent[0].getDesc(), is("desc"));
    }

    /**
     * Проверка изменения заявки.
     */
    @Test
    public void whenChangeItem() {
        Tracker tracker = new Tracker();
        // Добавить заявку напрямую и получить ее id
        String id = tracker.add(new Item(null, "name", "desc", 0L, null)).getId();
        // Изменить заявку по ее id через пользовательский интерфейс и выйти из программы
        new StartUI(new StubInput(new String[]{"2", id, "newName", "newDesc", "6"}), tracker).init();
        // Проверить результат изменения
        Item[] trackerContent = tracker.findAll();
        assertThat(trackerContent.length, is(1));
        assertThat(trackerContent[0].getName(), is("newName"));
        assertThat(trackerContent[0].getDesc(), is("newDesc"));
    }

    /**
     * Проверка удаления заявки.
     */
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        // Добавить заявку напрямую и получить ее id
        String id = tracker.add(new Item(null, "name", "desc", 0L, null)).getId();
        // Удалить заявку по ее id через пользовательский интерфейс и выйти из программы
        new StartUI(new StubInput(new String[]{"3", id, "6"}), tracker).init();
        // Проверить результат удаления
        assertThat(tracker.findAll().length, is(0));
    }

    /**
     * Проверка вывода в консоль всех имеющихся заявок.
     */
    @Test
    public void whenShowAllItems() {
        String lineSeparator = System.lineSeparator();
        String menu =
                new StringJoiner(System.lineSeparator())
                        .add("-------------------------------------------------------")
                        .add("Меню:")
                        .add("0. Добавить новую заявку")
                        .add("1. Показать все имеющиеся заявки")
                        .add("2. Изменить заявку")
                        .add("3. Удалить заявку")
                        .add("4. Найти заявку по идентификатору")
                        .add("5. Найти заявки по имени")
                        .add("6. Выйти из программы")
                        .add("-------------------------------------------------------")
                        .toString();
        Tracker tracker = new Tracker();
        // Добавить 2 заявки
        tracker.add(new Item(null, "name", "desc", 0L, null));
        tracker.add(new Item(null, "name1", "desc1", 0L, null));
        // Вывести эти заявки (выбрать в меню "Показать все заявки"(1) и выйти из программы(6))
        new StartUI(new StubInput(new String[]{"1", "6"}), tracker).init();
        // Проверить содержимое байтового массива после вывода в него заявок (вместе с меню)
        assertThat(
                this.byteArrayOut.toString(),
                is(
                        menu
                        + lineSeparator
                        + "Список заявок:"
                        + lineSeparator
                        + tracker.findAll()[0].toString()
                        + lineSeparator
                        + tracker.findAll()[1].toString()
                        + lineSeparator
                        + menu
                        + lineSeparator
                )
        );
    }
}