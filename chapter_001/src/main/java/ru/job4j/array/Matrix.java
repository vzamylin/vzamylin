package ru.job4j.array;

/**
 * Класс для работы с матрицей.
 * @author vzamylin
 * @version 1
 * @since 05.03.2018
 */
public class Matrix {

    /**
     * Получить таблицу умножения заданной размерности.
     * @param size Размерность таблицы умножения.
     * @return Таблица умножения для чисел с 1 по размерность включительно.<br/>
     * Если задана неверная размерность (<=0), то возвращается пустая матрица.
     */
    public int[][] multiple(int size) {
        int[][] resultMatrix;
        if (size > 0) {
            resultMatrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    resultMatrix[row][column] = (row + 1) * (column + 1);
                }
            }
        } else {
            resultMatrix = new int[0][0];
        }
        return resultMatrix;
    }
}