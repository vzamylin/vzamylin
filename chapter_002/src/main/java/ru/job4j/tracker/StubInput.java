package ru.job4j.tracker;

/**
 * Реализация эмуляции ввода предопределенных значений (заглушка для тестов).
 * @author vzamylin
 * @version 1
 * @since 11.04.2018
 */
public class StubInput implements Input {
    private String[] values; // массив предопределенных значений для эмулируемого ввода
    private int position = 0; // текущий указатель на очередное значение в массиве

    /**
     * Конструктор.
     * @param values Массив предопределенных значений для эмулируемого ввода.
     */
    public StubInput(String[] values) {
        this.values = values;
    }

    /**
     * Эмуляция ответа пользователя.
     * @param question Любой фиктивный вопрос.
     *                 Параметр не анализируется и нужен лишь для соответствия сигнатуры аналогичному методу из реализуемого интерфейса.
     * @return Эмулируемый ответ как очередное предопределенное значение из массива, указанного при инициализации текущего объекта.
     */
    @Override
    public String ask(String question) {
        return this.values[this.position++];
    }
}