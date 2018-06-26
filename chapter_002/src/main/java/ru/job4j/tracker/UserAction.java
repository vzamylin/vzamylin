package ru.job4j.tracker;

/**
 * Действие пользователя.
 * @author vzamylin
 * @version 1
 * @since 25.06.2018
 */
public interface UserAction {
    /**
     * Получить код действия.
     * @return Код действия.
     */
    int key();

    /**
     * Выполнить действие.
     * @param input Интерфейс ввода данных.
     * @param tracker Хранилище заявок.
     * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
     */
    boolean execute(Input input, Tracker tracker);

    /**
     * Получить информацию о действии.
     * @return Информация о действии.
     */
    String info();
}