package ru.job4j.calculator;

/**
 * Класс Calculator для выполнения вычислений
 * @author vzamylin
 * @version 1
 * @since 07.02.2018
*/
public class Calculator {
    private double result;

    /**
     * Сложение двух чисел.
     * @param first 1-ое слагаемое.
     * @param second 2-ое слагаемое.
    */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание двух чисел.
     * @param first Уменьшаемое.
     * @param second Вычитаемое.
    */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление двух чисел.
     * @param first Делимое.
     * @param second Делитель.
    */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение двух чисел.
     * @param first 1-ый множитель.
     * @param second 2-ой множитель.
    */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Получение результата последней выполненной операции вычисления.
     * @return Результат последней операции.
    */
    public double getResult() {
        return this.result;
    }
}
