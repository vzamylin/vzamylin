package ru.job4j.loop;

/**
 * Класс для рисования фигур в псевдографике.
 * @author vzamylin
 * @version 1
 * @since 24.02.2018
 */
public class Paint {

    /** Нарисовать пирамиду в псевдографике.
     * @param h Высота пирамиды.
     * @return Строковое отображение пирамиды, состоящее из символов ^ и пробелов.
     * Например, пирамида высотой 3 будет иметь вид:<br/>
     * &nbsp;&nbsp;^&nbsp;&nbsp;<br/>
     * &nbsp;^^^&nbsp;<br/>
     * ^^^^^<br/>
     * Если задана некорректная высота (<=0), то "-1".<br/>
     * <br/>
     * <u>Описание работы метода.</u><br/>
     * <br/>
     * 1. Находим ширину пирамиды из расчета:
     * на каждую дополнительную строку сверх первой добавляется по две позиции в ширину - по одной слева и справа от центра пирамиды.<br/>
     * 2. Исходя из найденной ширины, вычисляем позицию центрального столбца.<br/>
     * 3. Непосредственно строим пирамиду, идем внешним циклом по строкам, внутренним циклом по столбцам.
     * Заполняем позиции по следующему принципу:<br/>
     * на 1-ой строке пирамиды символ ^ будет только в позиции центрального столбца,<br/>
     * на 2-ой - в диапазоне +-1 от центрального столбца, на 3-ей - +-2 от центрального столбца и т.д.<br/>
     * Соответственно, в остальных позициях будут пробелы.
     *
     */
    public String pyramid(int h) {
        StringBuilder screen = new StringBuilder();
        if (h > 0) {
            String ln = System.lineSeparator(); // Разделитель строк
            int width = 1 + 2 * (h - 1); // Ширина пирамиды
            int centColumn = (width - 1) / 2 + 1; // Позиция центрального столбца пирамиды
            // Строим пирамиду
            for (int row = 1; row <= h; row++) {
                for (int column = 1; column <= width; column++) {
                    if (centColumn - (row - 1) <= column && column <= centColumn + (row - 1)) {
                        screen.append("^");
                    } else {
                        screen.append(" ");
                    }
                }
                // Переход на следующую строку (после последней строки не нужен)
                if (row < h) {
                    screen.append(ln);
                }
            }
        } else {
            screen.append("-1");
        }
        return screen.toString();
    }
}