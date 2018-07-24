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
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = menu.getAvailableKeys();
        boolean exit;
        do {
            menu.show();
            exit = menu.executeByKey(this.input.ask("Введите пункт меню:", range));
        } while (!exit);
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}