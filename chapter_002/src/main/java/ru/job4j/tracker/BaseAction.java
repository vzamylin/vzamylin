package ru.job4j.tracker;

/**
 * Абстрактное действие пользователя (с реализацией только общих методов).
 * @author vzamylin
 * @version 1
 * @since 10.10.2018
 */
abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    /**
     * Конструктор.
     * @param key Код действия.
     * @param name Название действия.
     */
    BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Получить код действия.
     * @return Код действия.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Получить информацию о действии.
     * @return Информация о действии.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}