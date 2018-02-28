package ru.job4j.array;

/**
 * Класс для поиска элементов в массиве.
 * @author vzamylin
 * @version 1
 * @since 01.03.2018
 */
public class FindLoop {

    /**
     * Поиск индекса заданного элемента массива.
     * @param array Массив, в котором ищем элемент.
     * @param elementVal Значение элемента, индекс которого надо найти.
     * @return Индекс элемента с заданным значением. Если элемента нет в массиве, то -1.
     */
    public int indexOf(int[] array, int elementVal) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementVal) {
                result = i;
                break;
            }
        }
        return result;
    }
}