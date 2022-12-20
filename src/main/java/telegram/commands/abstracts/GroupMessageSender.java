package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.util.KeyBoardSetter;
import telegram.commands.util.UserPull;

public class GroupMessageSender{

    public static void sendMessage(AbsSender absSender, Object group, String text){
        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                SingleMessageSender.sendMessage(absSender, member.getChatId(), text);
            }
        }
    }

    public static void sendMessageWithKeyboard(AbsSender absSender, Object group, String text){
        SendMessage message = new SendMessage();
        message.setText(text);

        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                KeyBoardSetter.setButtonsIn(message, member);
                message.setChatId(member.getChatId().toString());
                SingleMessageSender.sendMessage(absSender, message);
            }
        }
    }
}
