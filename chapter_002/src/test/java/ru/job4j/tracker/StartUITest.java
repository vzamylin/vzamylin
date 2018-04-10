package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты пользовательского интерфейса системы заявок (Tracker).
 * @author vzamylin
 * @version 1
 * @since 11.04.2018
 */
public class StartUITest {

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
}