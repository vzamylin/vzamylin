package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для глупого бота.
 * @author vzamylin
 * @version 1
 * @since 12.02.2018
 */
public class DummyBotTest {

    /**
     * Тест ответа на приветствие.
     */
    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Привет, Бот."), is("Привет, умник."));
    }

    /**
     * Тест ответа на прощание.
     */
    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Пока."), is("До скорой встречи."));
    }

    /**
     * Тест ответа на неизвестную фразу.
     */
    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Как дела?"), is("Это ставит меня в тупик. Спросите другой вопрос."));
    }
}