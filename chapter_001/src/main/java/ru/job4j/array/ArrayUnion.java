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
     * <br/>
     * <u>Описание работы метода.</u><br/>
     * <br/>
     * Идем в рамках одного цикла сразу по двум исходным массивам, каждый проходим с начального элемента.<br/>
     * Сравниваем попарно элементы из этих двух массивов, наименьший из них кладем в результирующий массив
     * и сдвигаем текущий индекс прохода у того массива, из которого взяли элемент.<br/>
     * Как только один из массивов прошли полностью,
     * все оставшиеся элементы из другого дописываем в конец результирующего массива.
     */
    public int[] unionSorted(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int indexFirst = 0;
        int indexSecond = 0;
        for (int indexResult = 0; indexResult < result.length; indexResult++) {
            if (indexFirst < first.length && indexSecond < second.length) {
                if (first[indexFirst] < second[indexSecond]) {
                    result[indexResult] = first[indexFirst++];
                } else {
                    result[indexResult] = second[indexSecond++];
                }
            } else {
                // Один из массивов прошли полностью, а другой не полностью - допишем в результирующий оставшиеся элементы из не пройденного.
                int[] remainder = indexFirst < first.length ? first : second; // Оставшийся не пройденный массив.
                int indexRemainder = indexFirst < first.length ? indexFirst : indexSecond;
                for (int i = indexRemainder; i < remainder.length; i++) {
                    result[indexResult++] = remainder[i];
                }
                break;
            }
        }
        return result;
    }
}