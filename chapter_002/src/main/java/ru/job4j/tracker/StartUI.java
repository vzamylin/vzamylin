package ru.job4j.tracker;

import java.util.StringJoiner;

/**
 * Класс для работы с пользовательским интерфейсом.
 * @author vzamylin
 * @version 1
 * @since 02.04.2018
 */
public class StartUI {
    private final Input   input; // Ввод данных
    private final Tracker tracker; // Хранилище заявок

    // Константы для действий меню
    private static final String ADD          = "0"; // Добавление новой заявки в хранилище
    private static final String SHOW_ALL     = "1"; // Показать все имеющиеся в хранилище заявки
    private static final String EDIT         = "2"; // Изменить заявку
    private static final String DELETE       = "3"; // Удалить заявку
    private static final String FIND_BY_ID   = "4"; // Найти заявку по идентификатору
    private static final String FIND_BY_NAME = "5"; // Найти заявки по имени
    private static final String EXIT         = "6"; // Выйти из программы

    /**
     * Конструктор.
     * @param input Ввод данных.
     * @param tracker Хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Показать меню.
     */
    private void showMenu() {
        System.out.println(
                new StringJoiner(System.lineSeparator())
                        .add("-------------------------------------------------------")
                        .add("Меню:")
                        .add("0. Добавить новую заявку")
                        .add("1. Показать все имеющиеся заявки")
                        .add("2. Изменить заявку")
                        .add("3. Удалить заявку")
                        .add("4. Найти заявку по идентификатору")
                        .add("5. Найти заявки по имени")
                        .add("6. Выйти из программы")
                        .add("-------------------------------------------------------")
                        .toString()
        );
    }

    /**
     * Добавить новую заявку.
     */
    private void addItem() {
        String name = this.input.ask("Введите название заявки:");
        String desc = this.input.ask("Введите описание заявки:");
        Item newItem = this.tracker.add(new Item(null, name, desc, System.currentTimeMillis(), null));
        System.out.println("Заявка с идентификатором " + newItem.getId() + " успешно создана.");
    }

    /**
     * Показать явно заданный массив заявок.
     * @param items Заданный массив заявок.
     * @param msgExist Сообщение, выводимое перед списком заявок, если заявки есть в массиве.
     * @param msgNotExist Сообщение, выводимое при отсутствии заявок в массиве.
     */
    private void showItems(Item[] items, String msgExist, String msgNotExist) {
        if (items.length > 0) {
            System.out.println(msgExist);
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println(msgNotExist);
        }
    }

    /**
     * Показать все имеющиеся заявки.
     */
    private void showAll() {
        showItems(this.tracker.findAll(), "Список заявок:", "Заявок нет");
    }

    /**
     * Изменить заявку.
     */
    private void changeItem() {
        String id = this.input.ask("Введите идентификатор изменяемой заявки:");
        String newName = this.input.ask("Введите новое название заявки:");
        String newDesc = this.input.ask("Введите новое описание заявки:");
        if (this.tracker.replace(id, new Item(null, newName, newDesc, System.currentTimeMillis(), null))) {
            System.out.println("Заявка успешно изменена");
        } else {
            System.out.println("Заявка с указанным идентификатором не найдена");
        }
    }

    /**
     * Удалить заявку.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите идентификатор удаляемой заявки:");
        System.out.println(this.tracker.delete(id) ? "Заявка успешно удалена" : "Заявка с указанным идентификатором не найдена");
    }

    /**
     * Найти заявку по идентификатору.
     */
    private void findItemById() {
        Item item = this.tracker.findById(this.input.ask("Введите идентификатор искомой заявки:"));
        if (item != null) {
            System.out.println(new StringJoiner(System.lineSeparator()).add("Найдена заявка:").add(item.toString()));
        } else {
            System.out.println("Заявка с указанным идентификатором не найдена");
        }
    }

    /**
     * Найти заявки по имени.
     */
    private void findItemsByName() {
        showItems(
                this.tracker.findByName(this.input.ask("Введите имя искомых заявок:")),
                "Найдены заявки:",
                "Заявки с указанным именем не найдены"
        );
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        do {
            this.showMenu();
            switch (this.input.ask("Введите пункт меню:")) {
                case ADD:
                    this.addItem();
                    break;
                case SHOW_ALL:
                    this.showAll();
                    break;
                case EDIT:
                    this.changeItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findItemById();
                    break;
                case FIND_BY_NAME:
                    this.findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Введен недопустимый пункт!");
                    break;
            }
        } while (!exit);
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}