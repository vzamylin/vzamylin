package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

/**
 * Тесты для дубликатов элементов в массиве.
 * @author vzamylin
 * @version 1
 * @since 07.03.2018
 */
public class ArrayDuplicateTest {

    /**
     * Проверка отсутствия удаления дубликатов в пустом массиве.
     */
    @Test
    public void whenArrayIsEmpty() {
        assertThat(new ArrayDuplicate().remove(new String[]{}), is(new String[]{}));
    }

    /**
     * Проверка отсутствия удаления дубликатов в массиве c одним элементом.
     */
    @Test
    public void whenArrayLengthIsOne() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        assertThat(arrayDuplicate.remove(new String[]{""}), is(new String[]{""}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello"}), is(new String[]{"Hello"}));
    }

    /**
     * Проверка отсутствия удаления дубликатов в массиве с несколькими исключительно уникальными элементами.
     */
    @Test
    public void whenArrayContainsOnlyUniqueElements() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "hello"}), is(new String[]{"Hello", "hello"}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "hello", "World", "world"}), is(new String[]{"Hello", "hello", "World", "world"}));
    }

    /**
     * Проверка удаления дубликатов в массиве при их наличии.
     */
    @Test
    public void whenArrayContainsDuplicateElements() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "Hello"}), is(new String[]{"Hello"}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "Hello", "Hello", "Hello"}), is(new String[]{"Hello"}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "World", "Hello"}), arrayContainingInAnyOrder(new String[]{"World", "Hello"}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "World", "Hello", "Hello", "World", "Good"}), arrayContainingInAnyOrder(new String[]{"World", "Hello", "Good"}));
        assertThat(arrayDuplicate.remove(new String[]{"Hello", "Hello", "World", "World", "Good", "Good", "Good"}), arrayContainingInAnyOrder(new String[]{"World", "Hello", "Good"}));
    }
}