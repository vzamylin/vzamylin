package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Реализация консольного ввода данных.
 * @author vzamylin
 * @version 1
 * @since 01.04.2018
 */
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Задать вопрос пользователю и получить ответ.
     * @param question Вопрос.
     * @return Ответ.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return this.scanner.nextLine();
    }
}