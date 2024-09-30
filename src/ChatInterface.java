import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.*;

public class ChatInterface {
    private BorderPane layout;
    private VBox messageContainer; // Контейнер для сообщений
    private ScrollPane scrollPane; // Прокручиваемая область для сообщений
    private TextField userInput;



    public ChatInterface() {
        layout = new BorderPane();

        messageContainer = new VBox(10); // Контейнер для сообщений с отступом
        scrollPane = new ScrollPane(messageContainer); // Оборачиваем контейнер в ScrollPane
        scrollPane.setFitToWidth(true); // Сообщения будут подстраиваться под ширину
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Всегда показываем вертикальный скролл

        userInput = new TextField();

        layout.setCenter(scrollPane); // Сообщения в центре
        layout.setBottom(userInput);  // Поле для ввода внизу

        // Настройка отступов для поля ввода
        BorderPane.setMargin(userInput, new Insets(10));
    }

    public BorderPane getLayout() {
        return layout;
    }

    public void setupEventHandlers() {
        userInput.setOnAction(e -> {
            String input = userInput.getText();
            if (!input.isEmpty()) {
                ChatLogic.handleUserMessage(input, this,scrollPane);
                scrollPane.setVvalue(1.0);
                userInput.clear();  // Очищаем поле после отправки сообщения

            }

        });


    }

    public void startChat() {
        // Загрузка предыдущих сообщений
        ChatLogic.loadPreviousMessages(this);

        // Прочие настройки интерфейса, например, создание поля ввода, кнопки и т.д.
    }

    public void displayUserMessage(String message) {
        HBox userMessageBox = createMessageBox(message, Pos.BASELINE_RIGHT, "lightblue",scrollPane);
        messageContainer.getChildren().add(userMessageBox); // Добавляем сообщение пользователя
        VBox.setMargin(userMessageBox, new Insets(3, 0, 2, 260)); // Отступы, чтобы сообщение было справа
    }

    public void displayBotMessage(String message) {
        HBox botMessageBox = createMessageBox(message, Pos.BASELINE_LEFT, "lightgray",scrollPane);
        messageContainer.getChildren().add(botMessageBox); // Добавляем сообщение бота
        VBox.setMargin(botMessageBox, new Insets(3, 50, 2, 0)); // Отступы, чтобы сообщение было слева
    }

    private HBox createMessageBox(String message, Pos alignment, String backgroundColor, ScrollPane scrollPane) {
        Text text = new Text(message);
        text.setWrappingWidth(200);  // Устанавливаем максимальную ширину текста для переноса
        HBox messageBox = new HBox(text);
        messageBox.setPadding(new Insets(7));
        messageBox.setSpacing(10);
        messageBox.setMaxWidth(0);
        messageBox.setAlignment(alignment); // Устанавливаем выравнивание
        messageBox.setStyle("-fx-border-color: black; -fx-background-color: " + backgroundColor + "; " +
                "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        scrollPane.setVvalue(1.0);                // Автопрокрутка вниз при добавлении новых сообщений
        return messageBox;

    }

}
