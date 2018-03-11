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
     * @param firstArray Первый исходный отсортированный массив.
     * @param secondArray Второй исходный отсортированный массив.
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
    public int[] unionSorted(int[] firstArray, int[] secondArray) {
        int[] resultArray;
        if (!this.isArraySorted(firstArray) || !this.isArraySorted(secondArray)) {
            resultArray = new int[0];
        } else {
            resultArray = new int[firstArray.length + secondArray.length];
            int startIndexOfSecondArray = 0;
            int currentIndexOfResultArray = -1;
            for (int i = 0; i < firstArray.length; i++) {
                for (int j = startIndexOfSecondArray; j < secondArray.length; j++) {
                    if (secondArray[j] <= firstArray[i]) {
                        resultArray[++currentIndexOfResultArray] = secondArray[j];
                        // Прошли полностью 2-ой массив - больше заходить в него не надо.
                        if (j == secondArray.length - 1) {
                            startIndexOfSecondArray = secondArray.length;
                        }
                    } else {
                        startIndexOfSecondArray = j;
                        break;
                    }
                }
                resultArray[++currentIndexOfResultArray] = firstArray[i];
            }
            // Если при пройденном 1-ом массиве 2-ой не прошли полностью, допишем из последнего оставшиеся элементы в результирующий.
            for (int j = startIndexOfSecondArray; j < secondArray.length; j++) {
                resultArray[++currentIndexOfResultArray] = secondArray[j];
            }
        }
        return resultArray;
    }
}