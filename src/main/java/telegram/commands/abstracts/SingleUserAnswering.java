package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface SingleUserAnswering {

    default void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text){
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
