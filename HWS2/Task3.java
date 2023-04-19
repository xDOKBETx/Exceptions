package HWS2;

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90; // объявление переменной a
            int b = 3; // объявление переменной b
            System.out.println(a / b); // вывод результата деления a на b
            printSum(23, 234); // вызов метода printSum с параметрами 23 и 234
            int[] abc = { 1, 2 }; // объявление и инициализация массива abc
            abc[3] = 9; // попытка присвоить значение элементу массива с индексом 3 (вызовет ArrayIndexOutOfBoundsException)
        } catch (ArithmeticException ex) { // блок catch для обработки ошибки деления на ноль
            System.out.println("Деление на ноль!");
        } catch (FileNotFoundException ex) { // блок catch для обработки ошибки FileNotFoundException, которая может возникнуть в методе printSum
            System.out.println("Файл не найден!");
        } catch (ArrayIndexOutOfBoundsException ex) { // блок catch для обработки ошибки выхода за пределы массива
            System.out.println("Индекс вне диапазона!");
        } catch (Exception ex) { // блок catch для обработки всех других исключений
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b); // вывод суммы a и b
        throw new FileNotFoundException(); // генерация исключения FileNotFoundException
    }

}
