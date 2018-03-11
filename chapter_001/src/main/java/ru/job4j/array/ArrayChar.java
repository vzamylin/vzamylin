package ru.job4j.array;

/**
 * Обертка над строкой.
 * @author vzamylin
 * @version 2
 * @since 12.03.2018
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

    /**
     * Проверяет содержание указанной подстроки в исходной строке.
     * @param origin Исходная строка.
     * @param sub Подстрока.
     * @return true, если подстрока содержится в исходной строке, иначе false.
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        for (int i = 0; i <= origin.length() - sub.length(); i++) {
            if (new ArrayChar(origin.substring(i)).startWith(sub)) {
                result = true;
                break;
            }
        }
        return result;
    }
}