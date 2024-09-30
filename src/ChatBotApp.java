import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatInterface chatInterface = new ChatInterface();  // Создаём интерфейс чата

        Scene scene = new Scene(chatInterface.getLayout(), 400, 400);  // Настройка сцены
        primaryStage.setTitle("Чат-бот на JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        chatInterface.setupEventHandlers();  // Подключаем обработку событий
    }

    public static void main(String[] args) {
        launch(args);  // Запуск приложения
    }
}
