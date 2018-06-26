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
        int result;
        do {
            menu.show();
            try {
                result = menu.executeByKey(Integer.parseInt(this.input.ask("Введите пункт меню:")));
            } catch (NumberFormatException e) {
                result = -1;
            }
            if (result == -1) {
                System.out.println("Введен недопустимый пункт!");
            }
        } while (result != 1);
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}