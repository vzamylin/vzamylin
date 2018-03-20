package ru.job4j.professions;

/**
 * Дом.
 * @author vzamylin
 * @version 1
 * @since 21.03.2018
 */
public class House {
    private String address;

    /**
     * Конструктор.
     * @param address Адрес дома.
     */
    public House(String address) {
        this.address = address;
    }

    /**
     * Получить адрес дома.
     * @return Адрес дома.
     */
    public String getAddress() {
        return this.address;
    }
}