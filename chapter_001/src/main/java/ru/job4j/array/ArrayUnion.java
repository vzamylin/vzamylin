package ru.job4j.array;

/**
 * Класс для объединения массивов.
 * @author vzamylin
 * @version 1
 * @since 11.03.2018
 */
public class ArrayUnion {

    /**
     * Проверка, что массив отсортирован.
     * @param array Проверяемый массив.
     * @return true, если массив отсортирован по возрастанию, иначе false.
     */
    public boolean isArraySorted(int[] array) {
        boolean result = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Составить новый отсортированный массив из элементов двух исходных отсортированных массивов.
     * @param first Первый исходный отсортированный массив.
     * @param second Второй исходный отсортированный массив.
     * @return Новый отсортированный массив, состоящий из элементов исходных массивов.<br/>
     * Если хотя бы один из исходных массивов не отсортирован, возвращается пустой массив.<br/>
     * <br/>
     * <u>Описание работы метода.</u><br/>
     * <br/>
     * Берем один из исходных массивов, например, 1-ый и проходим во внешнем цикле все его элементы. Для каждого из элементов 1-ого массива идем внутренним циклом по 2-ому массиву следующим образом:<br/>
     * <br/>
     * Для 1-ого элемента 1-ого массива: проходим с самого начала элементы 2-ого массива и записываем их в результирующий массив до тех пор, пока не встретился элемент, больший 1-ого элемента, запоминаем индекс этого встретившегося элемента для следующего прохода и записываем в результирующий массив сам 1-ый элемент.<br/>
     * <br/>
     * Для 2-ого элемента 1-ого массива: проходим элементы 2-ого массива, начиная с позиции запомненного на предыдущем проходе элемента, пишем их в результирующий массив до тех пор, пока не встретился элемент, больший 2-ого, запоминаем снова его индекс, пишем в результирующий массив сам 2-ой элемент.<br/>
     * <br/>
     * И т.д. вплоть до последнего элемента 1-ого массива, причем, после последней итерации не забываем дописать в результирующий массив оставшиеся элементы 2-ого массива, которые больше последнего элемента 1-ого массива, если таковые есть.
     *
     */
    public int[] unionSorted(int[] first, int[] second) {
        int[] result;
        if (!this.isArraySorted(first) || !this.isArraySorted(second)) {
            result = new int[0];
        } else {
            result = new int[first.length + second.length];
            int startIndexOfSecond = 0;
            int indexOfResult = -1;
            for (int indexOfFirst = 0; indexOfFirst < first.length; indexOfFirst++) {
                for (int indexOfSecond = startIndexOfSecond; indexOfSecond < second.length; indexOfSecond++) {
                    if (second[indexOfSecond] <= first[indexOfFirst]) {
                        result[++indexOfResult] = second[indexOfSecond];
                        // Прошли полностью 2-ой массив - больше заходить в него не надо.
                        if (indexOfSecond == second.length - 1) {
                            startIndexOfSecond = second.length;
                        }
                    } else {
                        startIndexOfSecond = indexOfSecond;
                        break;
                    }
                }
                result[++indexOfResult] = first[indexOfFirst];
            }
            // Если при пройденном 1-ом массиве 2-ой не прошли полностью, допишем из последнего оставшиеся элементы в результирующий.
            for (int indexOfSecond = startIndexOfSecond; indexOfSecond < second.length; indexOfSecond++) {
                result[++indexOfResult] = second[indexOfSecond];
            }
        }
        return result;
    }
}