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
        // Переворачиваем массив, т.е. располагаем в нем элементы в обратном порядке.
        for (int i = 0; i < (int) array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}