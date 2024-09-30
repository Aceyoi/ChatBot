import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatInterface chatInterface = new ChatInterface();  // Создаём интерфейс чата
        chatInterface.startChat(); //Отображение предыдущих переписок
        chatInterface.setupEventHandlers();  // Подключаем обработку событий

        // Установка иконки приложения
        primaryStage.getIcons().add(new Image("file:src/icon.jpg")); // путь к иконке

        Scene scene = new Scene(chatInterface.getLayout(), 500, 600);  // Настройка сцены
        primaryStage.setTitle("Чат-бот Лиzа");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Запретить изменение размера окна
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);  // Запуск приложения
    }
}


// Время
// Сложения
// Погода
// ИМЯ