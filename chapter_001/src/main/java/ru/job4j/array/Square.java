package ru.job4j.array;

/**
 * Класс для возведения чисел массива в квадрат.
 * @author vzamylin
 * @version 1
 * @since 28.02.2018
 */
public class Square {

    /**
     * Заполнение массива квадратами чисел.
     * @param bound Размерность массива.
     * @return Массив, состоящий из квадратов натуральных чисел от 1 до размерности массива.
     * Если задана неверная размерность массива (<=0), то вернется массив, состоящий из одного элемента со значением -1.
     */
    public int[] calculate(int bound) {
        int[] result;
        if (bound > 0) {
            result = new int[bound];
            for (int i = 0; i < bound; i++) {
                result[i] = (int) Math.pow(i + 1, 2);
            }
        } else {
            result = new int[]{-1};
        }
        return result;
    }
}