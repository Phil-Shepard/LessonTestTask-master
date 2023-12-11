package example.FakeBot;

import example.bot.Bot;

import java.util.ArrayList;
import java.util.List;

/**
 * Фейковый бот. Его задача сохранять все сообщения, которые отправил наш класс {@link BotLogic}
 */
public class FakeBot implements Bot {
    private final List<String> messages = new ArrayList<>();
    public List<String> getMessages() {
        return messages;
    }
    @Override
    public void sendMessage(Long chatId, String message) {
        messages.add(message);
    }
}

