package ru.job4j.tracker;

/**
 * Интерфейс ввода данных.
 * @author vzamylin
 * @version 2
 * @since 24.07.2018
 */
public interface Input {

    /**
     * Задать вопрос пользователю и получить ответ.
     * @param question Вопрос.
     * @return Ответ.
     */
    String ask(String question);

    /**
     * Задать вопрос пользователю и получить ответ с проверкой допустимости ответа.
     * @param question Вопрос.
     * @param range Список допустимых числовых значений ответа пользователя.
     * @return Ответ.
     */
    int ask(String question, int[] range);

    /**
     * Проверка вхождения указанного целого числа в указанный список допустимых значений.
     * @param value Проверяемое число.
     * @param range Список допустимых значений.
     * @return true - если число входит в указанный список, false - если не входит.
     */
    default boolean inRange(int value, int[] range) {
        boolean result = false;
        if (range != null && range.length > 0) {
            for (int currentValue: range) {
                if (value == currentValue) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}