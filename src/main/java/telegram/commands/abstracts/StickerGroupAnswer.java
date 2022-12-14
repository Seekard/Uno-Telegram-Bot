package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.commands.util.UserPull;


public interface StickerGroupAnswer {
    default void sendGroupAnswer(AbsSender absSender, String commandName, Object group, String text){
        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                sendAnswer(absSender, member.getChatId(), member.getUserName(), commandName, text);
            }
        }
    }

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
