package ru.job4j.max;

/**
 * Класс для нахождения максимальных чисел.
 * @author vzamylin
 * @version 1
 * @since 13.02.2018
*/
public class Max {

    /**
     * Максимум из двух чисел.
     * @param first 1-ое число.
     * @param second 2-ое число.
     * @return Максимальное из указанных чисел.
    */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}