package HWS2;

public class Task2 {

    public static void main(String[] args) {
        try {
            // создаем массив целых чисел и присваиваем значения
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            // инициализируем переменную d нулем, чтобы получить исключение при делении на ноль
            int d = 0;

            // выполняем деление на ноль, что вызывает исключение типа ArithmeticException
            double catchedRes1 = intArray[8] / d;

            // выводим результат в консоль
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            // перехватываем исключение типа ArithmeticException и выводим сообщение об ошибке в консоль
            System.out.println("Catching arithmetic exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            // перехватываем исключение типа ArrayIndexOutOfBoundsException и выводим сообщение об ошибке в консоль
            System.out.println("Catching array index out of bounds exception: " + e);
        } catch (Exception e) {
            // перехватываем любое другое исключение типа Exception и выводим сообщение об ошибке в консоль
            System.out.println("Catching generic exception: " + e);
        }
    }
}
