package ru.job4j.condition;

/**
 * Глупый бот
 * @author vzamylin
 * @version 1
 * @since 12.02.2018
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question Вопрос.
     * @return Ответ.
     */
    public String answer(String question) {
        String response;
        if (question.equals("Привет, Бот.")) {
            response = "Привет, умник.";
        } else if (question.equals("Пока.")) {
            response = "До скорой встречи.";
        } else {
            response = "Это ставит меня в тупик. Спросите другой вопрос.";
        }
        return response;
    }
}