package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SingleMessageSender {

    public static void sendMessage(AbsSender absSender, Long chatId, String text){
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        sendMessage(absSender, message);
    }

    public static void sendMessage(AbsSender absSender, SendMessage message){
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
