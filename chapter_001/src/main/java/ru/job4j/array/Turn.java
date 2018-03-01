package ru.job4j.array;

/**
 * Класс для переворачивания массива.
 * @author vzamylin
 * @version 1
 * @since 02.03.2018
 */
public class Turn {

    /**
     * Перевернуть массив задом наперёд.
     * @param array Исходный массив.
     * @return Перевернутый массив с расположением элементов в обратном порядке.
     */
    public int[] back(int[] array) {
        // Индекс элемента, ближайшего к середине массива со стороны его начала.
        int indexNearestCenter = (int) Math.floor(array.length / 2) - 1;
        // Переворачиваем массив, т.е. располагаем в нем элементы в обратном порядке.
        for (int i = 0; i <= indexNearestCenter; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}