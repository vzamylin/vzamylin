package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Тесты для хранилища заявок.
 * @author vzamylin
 * @version 1
 * @since 31.03.2018
 */
public class TrackerTest {

    /**
     * Добавить массив заявок в хранилище
     * и установить в этом массиве сгенерированные при добавлении id заявок.
     * @param items Добавляемый массив заявок.
     * @param tracker Хранилище, в которое добавляем.
     */
    private void addItemsToTracker(Item[] items, Tracker tracker) {
        for (Item item : items) {
            item.setId(
                    tracker.add(
                            new Item(
                                    null,
                                    item.getName(),
                                    item.getDesc(),
                                    item.getCreated(),
                                    item.getComments()
                            )
                    ).getId()
            );
        }
    }

    /**
     * Проверка добавления заявок.
     */
    @Test
    public void whenAddItem() {
        // Добавить одну заявку с проверкой содержимого
        Item[] items = new Item[]{
                new Item(null, "name", "desc", 213213333, new String[]{"comment1", "comment2"})
        };
        Tracker tracker = new Tracker();
        addItemsToTracker(items, tracker);
        assertThat(tracker.findAll(), is(items));
        // Добавить еще 100 пустых заявок (проверка автоматического расширения хранилища при превышении длины 100)
        Item[] items100 = new Item[100];
        for (int i = 0; i < items100.length; i++) {
            items100[i] = new Item();
        }
        addItemsToTracker(items100, tracker);
        // Проверить общее содержимое хранилища после добавления еще 100 заявок
        Item[] items101 = new Item[101];
        items101[0] = items[0];
        for (int i = 1; i < items101.length; i++) {
            items101[i] = items100[i - 1];
        }
        assertThat(tracker.findAll(), is(items101));
    }

    /**
     * Проверка замены заявок.
     */
    @Test
    public void whenReplaceItem() {
        // Добавим 5 заявок и проверим общее содержимое после добавления
        Tracker tracker = new Tracker();
        Item[] items = new Item[5];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(null, "name" + String.valueOf(i), "desc", 3232323L, new String[]{"comments"});
        }
        addItemsToTracker(items, tracker);
        Item[] trackerContent = tracker.findAll();
        assertThat(trackerContent, is(items));
        // Проверим содержимое 3-ей заявки перед заменой
        assertThat(trackerContent[2], is(items[2]));
        // Заменим 3-ю заявку
        Item newItem = new Item(null, "nm", "dsc", 32L, null);
        assertTrue(tracker.replace(trackerContent[2].getId(), newItem));
        // Проверим новое содержимое 3-ей заявки после замены
        trackerContent = tracker.findAll();
        assertThat(trackerContent[2], is(newItem));
        // Попробуем заменить заявку с несуществующим id
        Item[] trackerContentOld = Arrays.copyOf(trackerContent, trackerContent.length);
        assertFalse(tracker.replace("2333E", new Item()));
        assertFalse(tracker.replace(null, new Item()));
        // Проверим, что ничего не изменилось
        trackerContent = tracker.findAll();
        assertThat(trackerContent, is(trackerContentOld));
    }

    /**
     * Проверка удаления заявок.
     */
    @Test
    public void whenDeleteItem() {
        // Добавим 5 заявок
        Tracker tracker = new Tracker();
        Item[] items5 = new Item[5];
        for (int i = 0; i < items5.length; i++) {
            items5[i] = new Item(null, "name" + String.valueOf(i), "desc", 3232323L, new String[]{"comments"});
        }
        addItemsToTracker(items5, tracker);
        // Удалим последнюю заявку
        assertTrue(tracker.delete(tracker.findAll()[4].getId()));
        // Проверим, что в хранилище осталось только 4 первых заявки
        Item[] items4;
        items4 = Arrays.copyOf(items5, items5.length - 1);
        assertThat(tracker.findAll(), is(items4));
        // Удалим НЕ последнюю заявку из оставшихся 4-х (2-ую)
        assertTrue(tracker.delete(tracker.findAll()[1].getId()));
        // Проверим, что в хранилище остались только 1-ая, 3-я и 4-ая заявки, и расположены они без промежутков
        Item[] items3 = new Item[3];
        items3[0] = items4[0];
        items3[1] = items4[2];
        items3[2] = items4[3];
        assertThat(tracker.findAll(), is(items3));
        // Попробуем удалить заявку с несуществующим id
        Item[] trackerContent = tracker.findAll();
        Item[] trackerContentOld = Arrays.copyOf(trackerContent, trackerContent.length);
        assertFalse(tracker.delete("1F"));
        assertFalse(tracker.delete(null));
        // Проверим, что ничего не изменилось
        trackerContent = tracker.findAll();
        assertThat(trackerContent, is(trackerContentOld));
    }

    /**
     * Проверка поиска заявок по имени.
     */
    @Test
    public void whenFindItemsByName() {
        // Добавим 6 заявок, 3 из них сделаем с одинаковым именем
        Tracker tracker = new Tracker();
        Item[] items6 = new Item[6];
        for (int i = 0; i < items6.length; i++) {
            items6[i] = new Item(null, "name" + String.valueOf(i), "desc", 3232323L, new String[]{"comments"});
        }
        items6[1].setName("NAME_COMMON");
        items6[2].setName("NAME_COMMON");
        items6[4].setName("NAME_COMMON");
        addItemsToTracker(items6, tracker);
        // Проверим нахождение заявок с именем NAME_COMMON
        Item[] items3 = new Item[3];
        items3[0] = items6[1];
        items3[1] = items6[2];
        items3[2] = items6[4];
        assertThat(tracker.findByName("NAME_COMMON"), is(items3));
        // Попробуем найти заявки по несуществующему имени
        assertThat(tracker.findByName("NAME"), is(new Item[]{}));
        assertThat(tracker.findByName(null), is(new Item[]{}));
    }

    /**
     * Проверка поиска заявки по идентификатору id.
     */
    @Test
    public void whenFindItemById() {
        // Добавим 5 заявок
        Tracker tracker = new Tracker();
        Item[] items = new Item[5];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(null, "name" + String.valueOf(i), "desc", 3232323L, new String[]{"comments"});
        }
        addItemsToTracker(items, tracker);
        // Проверим нахождение заявок с существующим id
        assertThat(tracker.findById(items[0].getId()), is(items[0]));
        assertThat(tracker.findById(items[2].getId()), is(items[2]));
        assertThat(tracker.findById(items[4].getId()), is(items[4]));
        // Попытаемся найти заявки с несуществующим id
        assertNull(tracker.findById("W123"));
        assertNull(tracker.findById(null));
    }
}