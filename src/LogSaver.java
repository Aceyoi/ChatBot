import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class LogSaver {

    public static final String LOG_FILE = "chat_log.txt"; // Путь к файлу с логами

    // Метод для сохранения диалога в файл
    public static  void saveToLogFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();  // Добавляем новую строку
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Загружаем все сообщения из файла
    public static List<String> loadLogFile() {
        List<String> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
