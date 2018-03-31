package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Хранилище заявок.
 * @author vzamylin
 * @version 1
 * @since 27.03.2018
 */
public class Tracker {
    private static final Random RANDOM = new Random();
    private static final int    LENGTH_INCREMENT = 100; // Приращение размера хранилища, когда текущего размера не хватает для добавления новой заявки.
    private Item[]              items = new Item[LENGTH_INCREMENT]; // Заявки, содержащиеся в хранилище.
    private int                 position = 0; // Текущая позиция в массиве для следующей добавляемой заявки (указатель ячейки, в которую добавлять).

    /**
     * Сформировать уникальный идентификатор заявки.
     * @return Уникальный идентификатор заявки.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }

    /**
     * Найти внутренний индекс заявки в хранилище по ее идентификатору.
     * @param id Индентификатор заявки.
     * @return Индекс заявки с указанным идентификатором, если таковая существует в хралилище,
     * или -1, если не существет.
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int index = 0; index < this.items.length; index++) {
            // Дошли до 1-ого пустого элемента - сразу выходим, чтобы не перебирать оставшиеся пустые
            if (this.items[index] == null) {
                break;
            } else if (this.items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * Добавить новую заявку в хранилище.
     * @param item Добавляемая заявка без проставленного идентификатора id.
     * @return Добавленная заявка с проставленным уникальным идентификатором id.<br/>
     * При этом возвращаемая заявка совпадает с исходной, т.е. у исходной тоже проставляется id.
     */
    public Item add(Item item) {
        // Расширим хранилище, если места для добавления уже нет.
        if (this.position >= this.items.length) {
            this.items = Arrays.copyOf(this.items, this.items.length + LENGTH_INCREMENT);
        }
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Заменить заявку с указанным идентификатором на заданную.
     * Если заявка с указанным идентификатором не существует в хранилище, то ничего не происходит.
     * @param id Идентификатор заменяемой заявки.
     * @param item Заявка, на которую заменяем.
     */
    public void replace(String id, Item item) {
        int index = this.findIndexById(id);
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
        }
    }

    /**
     * Удалить из хранилища заявку с указанным идентификатором.<br/>
     * Если удаляемая заявка не последняя среди непустых, то все непустые заявки после нее сдвигаются на одну позицию влево,
     * т.е. после удаления хранилище не становится разреженным.<br/>
     * Если заявка с указанным идентификатором не существует в хранилище, то ничего не происходит.
     * @param id Идентификатор удаляемой заявки.
     */
    public void delete(String id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            int movingCount = this.position - 1 - index; // Кол-во непустых сдвигаемых заявок после удаляемой
            if (movingCount > 0) {
                System.arraycopy(this.items, index + 1, this.items, index, movingCount);
            }
            // При удалении последней непустой заявки сдвигаем указатель во избежание разреживания хранилища при следующем добавлении новой заявки
            this.items[--this.position] = null;
        }
    }

    /**
     * Получить список всех заявок.
     * @return Список всех непустых заявок (не null-элементы) из внутреннего массива.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Получить список всех заявок с указанным именем.
     * @param name Имя, по которому будут искаться заявки.
     * @return Список всех заявок с указанным именем.
     */
    public Item[] findByName(String name) {
        Item[] tempItems = new Item[this.position];
        int foundCount = 0; // Счетчик найденных заявок
        for (int index = 0; index < this.position; index++) { // Ищем только среди добавленных заявок (т.е. не null-заявок)
            String itemName = this.items[index].getName();
            if (itemName != null && itemName.equals(name)) {
                tempItems[foundCount++] = this.items[index];
            }
        }
        return Arrays.copyOf(tempItems, foundCount);
    }

    /**
     * Найти заявку по идентификатору.
     * @param id Идентификатор заявки.
     * @return Заявка с указанным идентификатором, если таковая существует в хранилище заявок,
     * или null, если не существует.
     */
    public Item findById(String id) {
        int index = this.findIndexById(id);
        return index != -1 ? this.items[index] : null;
    }
}