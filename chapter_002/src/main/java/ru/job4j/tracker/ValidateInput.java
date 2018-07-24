package ru.job4j.tracker;

/**
 * Консольный ввод данных с проверкой вводимых пользователем значений.
 * @author vzamylin
 * @version 1
 * @since 25.07.2018
 */
class ValidateInput extends ConsoleInput {

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
                result = super.ask(question, range);
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