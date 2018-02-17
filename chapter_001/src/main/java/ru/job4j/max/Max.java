package ru.job4j.max;

/**
 * Класс для нахождения максимальных чисел.
 * @author vzamylin
 * @version 2
 * @since 17.02.2018
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

    /**
     * Максимум из трех чисел.
     * @param first 1-ое число.
     * @param second 2-ое число.
     * @param third 3-е число.
     * @return Максимальное из указанных чисел.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}