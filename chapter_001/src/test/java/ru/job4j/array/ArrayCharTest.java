package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты обертки над строкой.
 * @author vzamylin
 * @version 2
 * @since 12.03.2018
 */
public class ArrayCharTest {

    /**
     * Проверка начала слова с префикса, когда префикс пустой, а слово не пустое.
     */
    @Test
    public void whenPrefixIsEmptyAndWordIsNotEmpty() {
        assertThat(new ArrayChar("Привет").startWith(""), is(true));
    }

    /**
     * Проверка начала слова с префикса, когда префикс пустой, и слово пустое.
     */
    @Test
    public void whenPrefixIsEmptyAndWordIsEmpty() {
        assertThat(new ArrayChar("").startWith(""), is(true));
    }

    /**
     * Проверка начала слова с префикса, когда длина префикса превышает длину слова.
     */
    @Test
    public void whenPrefixLengthMoreThanWordLength() {
        assertThat(new ArrayChar("").startWith("При"), is(false));
        assertThat(new ArrayChar("Привет").startWith("Привет."), is(false));
    }

    /**
     * Проверка начала слова с префикса, когда префикс совпадает с началом слова.
     */
    @Test
    public void whenPrefixIsBeginningOrWord() {
        ArrayChar arrayChar = new ArrayChar("Привет");
        assertThat(arrayChar.startWith("При"), is(true));
        assertThat(arrayChar.startWith("Привет"), is(true));
    }

    /**
     * Проверка начала слова с префикса, когда префикс не совпадает с началом слова.
     */
    @Test
    public void whenPrefixIsNotBeginningOrWord() {
        ArrayChar arrayChar = new ArrayChar("Привет");
        assertThat(arrayChar.startWith("при"), is(false));
        assertThat(arrayChar.startWith("риве"), is(false));
    }

    /**
     * Проверка содержания подстроки в исходной строке,
     * когда подстрока пустая, а исходная строка не пустая.
     */
    @Test
    public void whenSubStrIsEmptyAndOriginStrIsNotEmpty() {
        assertThat(new ArrayChar("").contains("123", ""), is(true));
    }

    /**
     * Проверка содержания подстроки в исходной строке,
     * когда подстрока пустая, и исходная строка пустая.
     */
    @Test
    public void whenSubStrIsEmptyAndOriginStrIsEmpty() {
        assertThat(new ArrayChar("").contains("", ""), is(true));
    }

    /**
     * Проверка содержания подстроки в исходной строке,
     * когда длина подстроки превышает длину исходной строки.
     */
    @Test
    public void whenSubStrLengthMoreThanOriginStrLength() {
        ArrayChar arrayChar = new ArrayChar("");
        assertThat(arrayChar.contains("", "1"), is(false));
        assertThat(arrayChar.contains("12", "12!"), is(false));
        assertThat(arrayChar.contains("123", "12345"), is(false));
    }

    /**
     * Проверка, что подстрока содержится в исходной строке.
     */
    @Test
    public void whenOriginStrContainsSubStr() {
        ArrayChar arrayChar = new ArrayChar("");
        assertThat(arrayChar.contains("12345", "1"), is(true));
        assertThat(arrayChar.contains("12345", "123"), is(true));
        assertThat(arrayChar.contains("12345", "234"), is(true));
        assertThat(arrayChar.contains("12345", "34"), is(true));
        assertThat(arrayChar.contains("12345", "345"), is(true));
        assertThat(arrayChar.contains("12345", "12345"), is(true));
    }

    /**
     * Проверка, что подстрока не содержится в исходной строке.
     */
    @Test
    public void whenOriginStrNotContainsSubStr() {
        ArrayChar arrayChar = new ArrayChar("");
        assertThat(arrayChar.contains("12345", "0"), is(false));
        assertThat(arrayChar.contains("12345", "0123"), is(false));
        assertThat(arrayChar.contains("12345", "13"), is(false));
        assertThat(arrayChar.contains("12345", "24"), is(false));
        assertThat(arrayChar.contains("12345", "35"), is(false));
        assertThat(arrayChar.contains("12345", "1345"), is(false));
        assertThat(arrayChar.contains("12345", "12346"), is(false));
    }
}