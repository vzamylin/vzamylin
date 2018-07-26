package ru.job4j.tracker;

/**
 * Класс для работы с пользовательским интерфейсом.
 * @author vzamylin
 * @version 2
 * @since 27.06.2018
 */
public class StartUI {
    private final Input   input; // Ввод данных
    private final Tracker tracker; // Хранилище заявок
    private boolean exit = false; // Признак выхода из программы

    /**
     * Конструктор.
     * @param input Ввод данных.
     * @param tracker Хранилище заявок.
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Установка признака выхода из программы.
     * @param exit Признак выхода из программы.
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this);
        menu.fillActions();
        int[] range = menu.getAvailableKeys();
        do {
            menu.show();
            menu.executeByKey(this.input.ask("Введите пункт меню:", range));
        } while (!this.exit);
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}