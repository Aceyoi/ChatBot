import java.util.List;
import javafx.scene.control.ScrollPane;

public class ChatLogic {

    public static void handleUserMessage(String message, ChatInterface chatInterface, ScrollPane scrollPane) {
        chatInterface.displayUserMessage(message); // Отображаем сообщение пользователя
        String botResponse = getBotResponse(message); // Определяем ответ бота
        chatInterface.displayBotMessage(botResponse); // Отображаем ответ бота


        // Логируем сообщения в файл
        LogSaver.saveToLogFile("Вы: " + message);
        LogSaver.saveToLogFile("Бот: " + botResponse);

    }

    // Загружаем предыдущие сообщения из файла при запуске
    public static void loadPreviousMessages(ChatInterface chatInterface) {
        List<String> logMessages = LogSaver.loadLogFile();

        for (String message : logMessages) {
            if (message.startsWith("Вы: ")) {
                chatInterface.displayUserMessage(message.replace("Вы: ", ""));
            } else if (message.startsWith("Бот: ")) {
                chatInterface.displayBotMessage(message.replace("Бот: ", ""));
            }
        }
    }

    // Основной метод для выбора ответа
    public static String getBotResponse(String input) {
        switch (input.toLowerCase()) {
            case "привет": return greetUser();
            case "как тебя зовут?": return getBotName();
            case "сколько время?": return getCurrentTime();
            case "как дела?": return askAboutBot();
            case "какая сегодня дата?": return getCurrentDate();
            case "что ты умеешь?": return whatCanYouDo();
            case "расскажи шутку": return tellJoke();
            case "что такое java?": return whatIsJava();
            case "какая погода?": return getWeather();
            case "расскажи интересный факт": return tellInterestingFact();
            case "какой твой любимый цвет?": return getFavoriteColor();
            case "какая твоя любимая еда?": return getFavoriteFood();
            case "кто твой создатель?": return whoIsCreator();
            case "как мне научиться программировать?": return learnProgramming();
            case "как улучшить навыки программирования?": return improveCodingSkills();
            case "что такое искусственный интеллект?": return whatIsAI();
            case "где я нахожусь?": return locationUnknown();
            case "расскажи анекдот": return tellJoke();
            case "что такое интернет?": return whatIsInternet();
            case "до свидания": return goodbye();
            default: return unknownCommand();
        }
    }

    // Методы для различных запросов

    private static String greetUser() {
        return "Привет! Рад тебя видеть. Чем могу помочь?";
    }

    private static String getBotName() {
        return "Меня зовут ChatBot!";
    }

    private static String getCurrentTime() {
        java.time.LocalTime time = java.time.LocalTime.now();
        return "Сейчас " + time.toString().substring(0, 5);
    }

    private static String askAboutBot() {
        return "У меня всё отлично! А как ты?";
    }

    private static String getCurrentDate() {
        java.time.LocalDate date = java.time.LocalDate.now();
        return "Сегодня " + date.toString();
    }

    private static String whatCanYouDo() {
        return "Я могу помочь тебе с программированием, рассказать шутку или просто поболтать!";
    }

    private static String tellJoke() {
        return "Почему программисты не любят природу? Потому что там слишком много багов!";
    }

    private static String whatIsJava() {
        return "Java — это объектно-ориентированный язык программирования, который используется для создания приложений.";
    }

    private static String getWeather() {
        return "Сейчас я не умею получать информацию о погоде, но скоро научусь!";
    }

    private static String tellInterestingFact() {
        return "Знаешь ли ты, что первый программируемый компьютер был создан в 1941 году?";
    }

    private static String getFavoriteColor() {
        return "Мой любимый цвет — синий!";
    }

    private static String getFavoriteFood() {
        return "Я виртуальный, поэтому мне не нужно есть, но я бы попробовал пиццу!";
    }

    private static String whoIsCreator() {
        return "Меня создал программист по имени Юрий!";
    }

    private static String learnProgramming() {
        return "Начни с основ: изучи Python или Java, они хорошо подходят для новичков!";
    }

    private static String improveCodingSkills() {
        return "Практикуйся каждый день, участвуй в проектах и не забывай читать документацию.";
    }

    private static String whatIsAI() {
        return "Искусственный интеллект — это область информатики, которая занимается созданием умных машин, способных выполнять задачи, требующие человеческого интеллекта.";
    }

    private static String locationUnknown() {
        return "Я не знаю, где ты находишься, но надеюсь, что у тебя всё хорошо!";
    }

    private static String whatIsInternet() {
        return "Интернет — это глобальная система взаимосвязанных компьютерных сетей, которая использует стандартизованные протоколы для обмена информацией.";
    }

    private static String goodbye() {
        return "До свидания! Надеюсь, скоро увидимся.";
    }

    private static String unknownCommand() {
        return "Извини, я пока не понимаю этот запрос. Попробуй спросить что-нибудь другое!";
    }
}
