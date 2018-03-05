package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты обертки над строкой.
 * @author vzamylin
 * @version 1
 * @since 06.03.2018
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
}