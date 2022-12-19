package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.util.UserPull;

public class GroupMessageSender{

    public static void sendMessage(AbsSender absSender, String commandName, Object group, String text){
        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                SingleMessageSender.sendMessage(absSender, member.getChatId(), member.getUserName(), commandName, text);
            }
        }
    }
}
