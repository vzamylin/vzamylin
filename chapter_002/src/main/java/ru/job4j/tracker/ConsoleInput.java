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

    /**
     * Задать вопрос пользователю и получить ответ с проверкой допустимости ответа.
     * @param question Вопрос.
     * @param range Список допустимых числовых значений ответа пользователя.
     * @return Ответ.
     * @throws NumberFormatException если введено не число.
     * @throws MenuOutException если введено число не из допустимого списка.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = Integer.parseInt(this.ask(question));
        boolean inRange = false;
        if (range != null && range.length > 0) {
            for (int value: range) {
                if (result == value) {
                    inRange = true;
                    break;
                }
            }
        }
        if (!inRange) {
            throw new MenuOutException("Введите число из указанного списка.");
        }
        return result;
    }
}