package ru.job4j.loop;

/**
 * Класс для вычислений в циклах.
 * @author vzamylin
 * @version 1
 * @since 20.02.2018
 */
public class Counter {

    /**
     * Сумма четных чисел в заданном диапазоне.
     * @param start Начальное число диапазона.
     * @param finish Конечное число диапазона.
     * @return Сумма четных чисел в указанном диапазоне, 0 - если четных чисел в диапазоне нет.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}