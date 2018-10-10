package ru.job4j.tracker;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Меню действий пользователя.
 * @author vzamylin
 * @version 2
 * @since 11.10.2018
 */
public class MenuTracker {
    private final Input   input;
    private final Tracker tracker;
    private final StartUI ui;
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     * @param input Ввод данных.
     * @param tracker Хранилище заявок.
     * @param ui Пользовательский интерфейс.
     */
    MenuTracker(Input input, Tracker tracker, StartUI ui) {
        this.input = input;
        this.tracker = tracker;
        this.ui = ui;
    }

    /**
     * Заполнение внутреннего массива действий пользователя.<br/>
     * Внимание! При добавлении нового действия следить, чтобы код действия совпадал с его индексом в массиве.
     * Это сделано для оптимизации, чтобы на этапе выполнения действия (см. executeByKey()) можно было сразу обращаться к нему по индексу, а не искать в массиве.
     */
    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem(0, "Добавить новую заявку");
        this.actions[1] = this.new ShowAll(1, "Показать все имеющиеся заявки");
        this.actions[2] = new MenuTracker.ChangeItem(2, "Изменить заявку");
        this.actions[3] = new MenuTracker.DeleteItem(3, "Удалить заявку");
        this.actions[4] = new MenuTracker.FindItemById(4, "Найти заявку по идентификатору");
        this.actions[5] = this.new FindItemsByName(5, "Найти заявки по имени");
        this.actions[6] = new Exit(6, "Выйти из программы", this.ui);
    }

    /**
     * Показать меню действий.
     */
    public void show() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Меню:");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            } else {
                break;
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Выполнить действие с указанным кодом.<br/>
     * Предполагается, что код действия должен совпадать с его индексом во внутреннем массиве.
     * Это сделано для оптимизации, чтобы можно было сразу обращаться к действию по индексу, а не искать в массиве.
     * @param key Код действия.
     */
    public void executeByKey(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Получить список доступных кодов действий.
     * Имеет смысл вызывать после fillActions(), т.к. до этого момента список будет пустой.
     * @return Массив со списком кодов действий.
     */
    public int[] getAvailableKeys() {
        int[] keys = new int[this.actions.length];
        int count = 0;
        for (UserAction action: this.actions) {
            if (action == null) {
                break;
            } else {
                keys[count++] = action.key();
            }
        }
        return Arrays.copyOf(keys, count);
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
     * Действие "Добавить новую заявку".
     */
    private static class AddItem extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки:");
            String desc = input.ask("Введите описание заявки:");
            Item newItem = tracker.add(new Item(null, name, desc, System.currentTimeMillis(), null));
            System.out.println("Заявка с идентификатором " + newItem.getId() + " успешно создана.");
        }
    }

    /**
     * Действие "Показать все имеющиеся заявки".
     */
    private class ShowAll extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private ShowAll(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.showItems(tracker.findAll(), "Список заявок:", "Заявок нет");
        }
    }

    /**
     * Действие "Изменить заявку".
     */
    private static class ChangeItem extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private ChangeItem(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите идентификатор изменяемой заявки:");
            String newName = input.ask("Введите новое название заявки:");
            String newDesc = input.ask("Введите новое описание заявки:");
            if (tracker.replace(id, new Item(null, newName, newDesc, System.currentTimeMillis(), null))) {
                System.out.println("Заявка успешно изменена");
            } else {
                System.out.println("Заявка с указанным идентификатором не найдена");
            }
        }
    }

    /**
     * Действие "Удалить заявку".
     */
    private static class DeleteItem extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите идентификатор удаляемой заявки:");
            System.out.println(tracker.delete(id) ? "Заявка успешно удалена" : "Заявка с указанным идентификатором не найдена");
        }
    }

    /**
     * Действие "Найти заявку по идентификатору".
     */
    private static class FindItemById extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите идентификатор искомой заявки:"));
            if (item != null) {
                System.out.println(new StringJoiner(System.lineSeparator()).add("Найдена заявка:").add(item.toString()));
            } else {
                System.out.println("Заявка с указанным идентификатором не найдена");
            }
        }
    }

    /**
     * Действие "Найти заявки по имени".
     */
    private class FindItemsByName extends BaseAction {

        /**
         * Конструктор.
         * @param key  Код действия.
         * @param name Название действия.
         */
        private FindItemsByName(int key, String name) {
            super(key, name);
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker.this.showItems(
                    tracker.findByName(input.ask("Введите имя искомых заявок:")),
                    "Найдены заявки:",
                    "Заявки с указанным именем не найдены"
            );
        }
    }
}

/**
 * Действие "Выйти из программы".
 */
class Exit extends BaseAction {
    private final StartUI ui;

    /**
     * Конструктор.
     * @param key  Код действия.
     * @param name Название действия.
     * @param ui Пользовательский интерфейс.
     */
    Exit(int key, String name, StartUI ui) {
        super(key, name);
        this.ui = ui;
    }

    /**
     * Выполнить действие.
     * @param input   Интерфейс ввода данных.
     * @param tracker Хранилище заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.setExit(true);
    }
}