package ru.job4j.tracker;

import java.util.StringJoiner;

/**
 * Меню действий пользователя.
 * @author vzamylin
 * @version 1
 * @since 27.06.2018
 */
public class MenuTracker {
    private final Input   input;
    private final Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     * @param input Ввод данных.
     * @param tracker Хранилище заявок.
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполнение внутреннего массива действий пользователя.
     */
    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = this.new ShowAll();
        this.actions[2] = new MenuTracker.ChangeItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = this.new FindItemsByName();
        this.actions[6] = new Exit();
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
     * Выполнить действие с указанным кодом.
     * @param key Код действия.
     * @return Результат выполнения:<br/>
     *         0 - Действие успешно выполнено, работа программы продолжается.<br/>
     *         1 - Действие успешно выполнено, требуется выйти из программы.<br/>
     *         -1 - Действие с указанным кодом не найдено.
     */
    public int executeByKey(int key) {
        int result = -1;
        for (UserAction action : this.actions) {
            if (action == null) {
                break;
            } else if (action.key() == key) {
                result = action.execute(this.input, this.tracker) ? 1 : 0;
                break;
            }
        }
        return result;
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
    private static class AddItem implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки:");
            String desc = input.ask("Введите описание заявки:");
            Item newItem = tracker.add(new Item(null, name, desc, System.currentTimeMillis(), null));
            System.out.println("Заявка с идентификатором " + newItem.getId() + " успешно создана.");
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку");
        }
    }

    /**
     * Действие "Показать все имеющиеся заявки".
     */
    private class ShowAll implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            MenuTracker.this.showItems(tracker.findAll(), "Список заявок:", "Заявок нет");
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все имеющиеся заявки");
        }
    }

    /**
     * Действие "Изменить заявку".
     */
    private static class ChangeItem implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            String id = input.ask("Введите идентификатор изменяемой заявки:");
            String newName = input.ask("Введите новое название заявки:");
            String newDesc = input.ask("Введите новое описание заявки:");
            if (tracker.replace(id, new Item(null, newName, newDesc, System.currentTimeMillis(), null))) {
                System.out.println("Заявка успешно изменена");
            } else {
                System.out.println("Заявка с указанным идентификатором не найдена");
            }
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Изменить заявку");
        }
    }

    /**
     * Действие "Удалить заявку".
     */
    private static class DeleteItem implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            String id = input.ask("Введите идентификатор удаляемой заявки:");
            System.out.println(tracker.delete(id) ? "Заявка успешно удалена" : "Заявка с указанным идентификатором не найдена");
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }

    /**
     * Действие "Найти заявку по идентификатору".
     */
    private static class FindItemById implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите идентификатор искомой заявки:"));
            if (item != null) {
                System.out.println(new StringJoiner(System.lineSeparator()).add("Найдена заявка:").add(item.toString()));
            } else {
                System.out.println("Заявка с указанным идентификатором не найдена");
            }
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по идентификатору");
        }
    }

    /**
     * Действие "Найти заявки по имени".
     */
    private class FindItemsByName implements UserAction {

        /**
         * Получить код действия.
         * @return Код действия.
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * Выполнить действие.
         * @param input   Интерфейс ввода данных.
         * @param tracker Хранилище заявок.
         * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
         */
        @Override
        public boolean execute(Input input, Tracker tracker) {
            MenuTracker.this.showItems(
                    tracker.findByName(input.ask("Введите имя искомых заявок:")),
                    "Найдены заявки:",
                    "Заявки с указанным именем не найдены"
            );
            return false;
        }

        /**
         * Получить информацию о действии.
         * @return Информация о действии.
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявки по имени");
        }
    }
}

/**
 * Действие "Выйти из программы".
 */
class Exit implements UserAction {

    /**
     * Получить код действия.
     * @return Код действия.
     */
    @Override
    public int key() {
        return 6;
    }

    /**
     * Выполнить действие.
     * @param input   Интерфейс ввода данных.
     * @param tracker Хранилище заявок.
     * @return Признак необходимости выхода из программы после выполнения действия, true - выйти из программы, false - продолжить работу программы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        return true;
    }

    /**
     * Получить информацию о действии.
     * @return Информация о действии.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Выйти из программы");
    }
}