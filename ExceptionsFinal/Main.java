package ExceptionsFinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    // Константа для хранения ожидаемого количества данных
    private static final int REQUIRED_DATA_COUNT = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата рождения номер телефона пол ");
        String input = scanner.nextLine();

        // Разбиение строки ввода на отдельные поля
        String[] data = input.split(" ");

        // Проверка наличия правильного количества полей
        if (data.length != REQUIRED_DATA_COUNT) {
            System.out.println("Ошибка: неверное количество данных");
            return;
        }

        // Извлечение полей ФИО
        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];

        // Парсинг даты рождения
        LocalDate birthDate = parseBirthDate(data[3]);
        if (birthDate == null) {
            return;
        }

        // Парсинг номера телефона
        long phoneNumber = parsePhoneNumber(data[4]);
        if (phoneNumber == -1) {
            return;
        }

        // Парсинг пола
        char gender = parseGender(data[5]);
        if (gender == '\0') {
            return;
        }

        // Формирование имени файла для записи данных
        String fileName = "ExceptionsFinal/" + lastName + ".txt";
        File file = new File(fileName);

        // Проверка наличия файла с таким же именем
        boolean fileExists = file.exists();

        // Запись данных в файл
        if (writeToFile(file, lastName, firstName, middleName, birthDate, phoneNumber, gender, fileExists)) {
            System.out.println("Данные записаны в файл " + fileName);
        } else {
            System.out.println("Ошибка при записи в файл");
        }
    }

    // Метод для парсинга даты рождения
    private static LocalDate parseBirthDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты рождения (должен быть dd.mm.yyyy)");
            return null;
        }
    }

    // Метод для парсинга номера телефона
    private static long parsePhoneNumber(String phoneNumberStr) {
        try {
            return Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона (должно быть целое число без разделителей)");
            return -1;
        }
    }

    //  Метод для парсинга пола из строки
    private static char parseGender(String genderStr) {
        // Проверяем, что длина строки равна 1 символу и он является буквой
        if (genderStr.length() != 1 || !Character.isLetter(genderStr.charAt(0))) {
            System.out.println("Ошибка: пол должен быть задан символом (f - женский, m - мужской)");
            return '\0';
        } else {
            // Если проверка прошла успешно, то возвращаем символ пола
            return genderStr.charAt(0);
        }
    }

    // Метод для записи данных в файл

    private static boolean writeToFile(File file, String lastName, String firstName, String middleName,
                                       LocalDate birthDate, long phoneNumber, char gender, boolean fileExists) {
        try (FileWriter writer = new FileWriter(file, true)) { // Создаем объект для записи в файл
            if (fileExists) { // Если файл уже существует, добавляем перевод строки
                writer.write(System.lineSeparator());
            }

            // Записываем данные в файл в формате, указанном в задании
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + phoneNumber + " " + gender);

            return true;
        } catch (IOException e) { // Обработка ошибок
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return false;
        }
    }
}
