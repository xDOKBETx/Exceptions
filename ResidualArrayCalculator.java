public class ResidualArrayCalculator {

    public static void main(String[] args) {
        // Задаем исходный и вычитаемый массивы
        int[] sourceArray = {10, 1, 18, 3, 6, 4};
        int[] subtractedArray = {6, 5, 9, 3, 1};

        try {
            // Вычисляем остаточный массив и выводим его на консоль
            int[] resultArray = calculateResidualArray(sourceArray, subtractedArray);
            printArray(resultArray);
        } catch (IllegalArgumentException e) {
            // В случае, если массивы не равны по длине, выводим сообщение об ошибке
            System.out.println(e.getMessage());
        }
    }

    // Метод для вычисления остаточного массива
    public static int[] calculateResidualArray(int[] sourceArray, int[] subtractedArray) {
        // Проверяем, что массивы равны по длине
        if (!areArraysEqualLength(sourceArray, subtractedArray)) {
            throw new IllegalArgumentException("Массивы не равны по длине");
        }

        // Создаем новый массив для записи результата
        int[] resultArray = new int[sourceArray.length];

        // Вычисляем каждый элемент остаточного массива
        for (int i = 0; i < sourceArray.length; i++) {
            resultArray[i] = sourceArray[i] - subtractedArray[i];
        }

        // Возвращаем остаточный массив
        return resultArray;
    }

    // Метод для вывода массива на консоль
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf(element + " ");
        }
    }

    // Метод для проверки равенства длины массивов
    public static boolean areArraysEqualLength(int[] firstArray, int[] secondArray) {
        return firstArray.length == secondArray.length;
    }
}
