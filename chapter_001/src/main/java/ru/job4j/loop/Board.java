package ru.job4j.loop;

/**
 * Шахматная доска в псевдографике, состоящая из чередующихся символов X и пробелов.
 * @author vzamylin
 * @version 1
 * @since 22.02.2018
 */
public class Board {

    /**
     * Нарисовать доску.
     * @param width Ширина доски.
     * @param height Высота доски.
     * @return Строковое представление доски в псевдографике, состоящее из чередующихся символов X и пробелов.
     * Если задана неверная размерность доски (ширина или высота <= 0), то "-1".<br/>
     * <br/>
     * <u>Описание работы метода.</u><br/>
     * <br/>
     * При построении доски идем внешним циклом по строкам, внутренним циклом по столбцам.
     * Заполняем позиции по следующему принципу:<br/>
     * Считаем, что доска начинается с X (верхний левый угол), и далее идет чередование X и пробелов.<br/>
     * Тогда получаем, что X у нас встречается в нечетных строках доски на нечетных позициях
     * или в четных строках на четных позициях, т.е. на позициях с совпадающей четностью строк и столбцов.<br/>
     * Соответственно, на остальных позициях - пробелы.
     *
     *
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        if (width > 0 && height > 0) {
            String ln = System.lineSeparator(); // Разделитель строк
            for (int row = 1; row <= height; row++) {
                for (int column = 1; column <= width; column++) {
                    if (row % 2 == column % 2) {
                        screen.append("X");
                    } else {
                        screen.append(" ");
                    }
                }
                // Переход на следующую строку (после последней строки не нужен).
                if (row < height) {
                    screen.append(ln);
                }
            }
        } else {
            screen.append("-1");
        }
        return screen.toString();
    }
}