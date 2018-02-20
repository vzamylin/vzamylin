package ru.job4j.loop;

/**
 * Класс для вычисления факториала.
 * @author vzamylin
 * @version 1
 * @since 21.02.2018
 */
public class Factorial {

    /**
     * Вычислить факториал неотрициательного числа.
     * @param n Число, для которого вычисляется факториал.
     * @return Факториал числа, если оно неотрицательное, или -1, если отрицательное.
     */
    public int calc(int n) {
        int result = -1;
        if (n >= 0) {
            result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }
}