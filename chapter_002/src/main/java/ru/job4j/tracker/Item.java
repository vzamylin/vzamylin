package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

/**
 * Заявка.
 * @author vzamylin
 * @version 1
 * @since 27.03.2018
 */
public class Item {
    private String   id; // Идентификатор заявки
    private String   name; // Название заявки
    private String   desc; // Описание заявки
    private long     created; // Дата и время создания заявки (в мс)
    private String[] comments; // Комментарии к заявке

    /**
     * Конструктор без аргументов (для использования наследниками по умолчанию).
     */
    public Item() {
    }

    /**
     * Конструктор с аргументами.
     * @param id Идентификатор заявки.
     * @param name Название заявки.
     * @param desc Описание заявки.
     * @param created Дата и время создания заявки (в мс).
     * @param comments Комментарии к заявке.
     */
    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    /**
     * Получить идентификатор заявки.
     * @return Идентификатор заявки.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Установить идентификатор заявки.
     * @param id Идентификатор заявки.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Получить название заявки.
     * @return Название заявки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Установить название заявки.
     * @param name Название заявки.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить описание заявки.
     * @return Описание заявки.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Установить описание заявки.
     * @param desc Описание заявки.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Получить дату и время создания заявки (в мс).
     * @return Дата и время создания заявки (в мс).
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * Установить дату и время создания заявки (в мс).
     * @param created Дата и время создания заявки (в мс).
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * Получить комментарии к заявке.
     * @return Комментарии к заявке.
     */
    public String[] getComments() {
        return this.comments;
    }

    /**
     * Установить комментарии к заявке.
     * @param comments Комментарии к заявке.
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * Переопределенный метод сравнения объектов
     * (автоматически сгенерированный IDE метод, его реализация в данном случае подходит).
     * @param obj Сравниваемый с текущим объект класса Item или один из его наследников.
     * @return true, если объекты равны, false, если не равны.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return this.getCreated() == item.getCreated()
                && Objects.equals(this.getId(), item.getId())
                && Objects.equals(this.getName(), item.getName())
                && Objects.equals(this.getDesc(), item.getDesc())
                && Arrays.equals(this.getComments(), item.getComments());
    }

    /**
     * Переопределенный метод получения хэш кода.
     * Пока он нам не нужен, но требуется для проверки checkstyle,
     * поэтому оставляем по умолчанию метод суперкласса.
     * @return Хэш код.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Переопределенный метод строкового представления объекта.
     * @return Строковое представление текущего объекта Item, содержащее его поля.
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Item: ")
                .append("id = ").append(this.getId())
                .append(", name = ").append(this.getName())
                .append(", desc = ").append(this.getDesc())
                .append(", created = ").append(this.getCreated())
                .append(", comments = ").append(Arrays.toString(this.getComments()))
                .toString();
    }
}