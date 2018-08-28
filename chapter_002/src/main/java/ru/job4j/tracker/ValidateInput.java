package ru.job4j.tracker;

/**
 * Ввод данных с проверкой вводимых пользователем значений (обертка над обычным вводом данных).
 * @author vzamylin
 * @version 2
 * @since 28.08.2018
 */
class ValidateInput implements Input {
    private final Input input;

    /**
     * Конструктор
     * @param input Ввод данных.
     */
    ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Задать вопрос пользователю и получить ответ.
     * @param question Вопрос.
     * @return Ответ.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Задать вопрос пользователю и получить ответ с проверкой допустимости ответа.
     * Ввод запрашивается до тех пор, пока не будет получен допустимый ответ.
     * @param question Вопрос.
     * @param range Список допустимых числовых значений ответа пользователя.
     * @return Ответ.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        boolean valid = false;
        do {
            try {
                result = this.input.ask(question, range);
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число, а не произвольную строку.");
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            }
        } while (!valid);
        return result;
    }
}