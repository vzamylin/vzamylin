package ru.job4j.array;

/**
 * Обертка над строкой.
 * @author vzamylin
 * @version 1
 * @since 06.03.2018
 */
public class ArrayChar {
    private char[] data;

    /**
     * Конструктор для инициализации символьного массива из заданной строки.
     * @param line Строка.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово, содержащееся в текущем объекте, начинается с заданного префикса.
     * @param prefix Префикс.
     * @return true, если слово начинается с указанного префикса, в противном случае false.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] prefixCharArray = prefix.toCharArray();
        if (prefixCharArray.length > this.data.length) {
            result = false;
        } else {
            for (int i = 0; i < prefixCharArray.length; i++) {
                if (this.data[i] != prefixCharArray[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}