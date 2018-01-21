package ru.job4j;

/**
 * Класс Calculate для выполнения вычислений
 * @author vzamylin
 * @version 1
 * @since 19.01.2018
*/
public class Calculate {
	
	/**
	 * Основной метод, выполняемый при запуске класса (точка входа)
	 * @param args передаваемые параметры
	*/
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	/**
	 * Method echo.
	 * @param name Any input string.
	 * @return Echo plus input string.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}