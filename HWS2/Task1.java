package HWS2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        // вызываем метод для чтения числа с плавающей запятой из консоли
        float number = readFloatFromConsole();
        // выводим на экран введенное число
        System.out.println("Введенно число: " + number);
    }

    // метод для чтения числа с плавающей запятой из консоли
    public static float readFloatFromConsole() {
        Scanner scanner = new Scanner(System.in); // создаем объект Scanner для чтения ввода с консоли
        float number = 0; // инициализируем переменную number нулем
        boolean validInput = false; // устанавливаем флаг в false, чтобы начать цикл do-while
        do {
            System.out.print("Введите число с плавающей запятой: "); // просим пользователя ввести число
            try {
                number = Float.parseFloat(scanner.nextLine()); // пытаемся преобразовать строку во float
                validInput = true; // устанавливаем флаг в true, чтобы завершить цикл do-while
            } catch (NumberFormatException e) { // обрабатываем ошибку, если пользователь ввел что-то, кроме числа
                System.out.println("Неверный Ввод! Пожалуйста, введите число с плавающей запятой.");
            }
        } while (!validInput); // продолжаем цикл, пока пользователь не введет корректное значение
        return number; // возвращаем введенное пользователем число
    }
}
