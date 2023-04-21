package ErrorHandlingInProgramming;

public class ErrorHandlingDemo {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;
        int[] array = {1, 2, 3};
        Object obj = "2a";

        try {
            int quotient = divide(numerator, denominator);
            System.out.println(quotient);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            int value = findValueAtIndex(array, numerator);
            System.out.println(value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            int sum = addNumbers(numerator, obj);
            System.out.println(sum);
        } catch (ClassCastException e) {
            System.out.println("Невозможно привести объект к целому числу");
        }
    }

    /**
     * Делит два целых числа и выдает исключение ArithmeticException, если делитель равен нулю.
     */
    public static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Нельзя делить на ноль");
        } else {
            return numerator / denominator;
        }
    }

    /**
     * Возвращает значение по указанному индексу в массиве и создает исключение ArrayIndexOutOfBoundsException,
     * если индекс выходит за пределы.
     */
    public static int findValueAtIndex(int[] arr, int index) {
        if(index >= arr.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        } else {
            return arr[index];
        }
    }

    /**
     * Суммирует два целых числа и создает исключение ClassCastException, если второй параметр не является целым числом.
     */
    public static int addNumbers(int num, Object obj) {
        if (obj instanceof Integer) {
            return num + (Integer) obj;
        } else {
            throw new ClassCastException("Невозможно привести объект к целому числу");
        }
    }
}
