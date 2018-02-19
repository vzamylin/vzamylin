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
        // Скорректируем границы диапазона до ближайших четных чисел, чтобы потом не проверять четность в цикле.
        if (start % 2 != 0) {
            start++;
        }
        if (finish % 2 != 0) {
            finish--;
        }
        // Рассчитаем нужную нам сумму четных чисел в диапазоне.
        for (int i = start; i <= finish; i += 2) {
            result += i;
        }
        return result;
    }
}