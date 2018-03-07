package ru.job4j.array;

/**
 * Класс для сортировки массива методом пузырька.
 * @author vzamylin
 * @version 1
 * @since 03.03.2018
 */
public class BubbleSort {

    /**
     * Отсортировать массив методом пузырька.
     * @param array Исходный неотсортированный массив.
     * @return Отсортированный массив.<br/><br/>
     * <u>Описание работы метода:</u><br/>
     * 1-ый проход - идем по всему массиву, выталкиваем попарными перестановками наибольший элемент на последнюю позицию.<br/>
     * 2-ой проход - идем до предпоследнего элемента (включительно), выталкиваем очередной наибольший элемент на предпоследнюю позицию.<br/>
     * И т.д. каждый последующий проход идем до элемента на 1 меньше, чем в предыдущем проходе, выталкивая очередной наибольший элемент на позицию того элемента, до которого (включительно) делаем проход.<br/>
     * Итого, последний проход - идем по первым двум элементам массива (с 0-ого по 1-ый включительно).
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            // Делаем очередной проход с начала массива до i-ого элемента включительно, но с учетом еще и следующего элемента,
            // с которым сравнивается текущий, поэтому условие в цикле задаем до i-ого элемента исключительно.
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}