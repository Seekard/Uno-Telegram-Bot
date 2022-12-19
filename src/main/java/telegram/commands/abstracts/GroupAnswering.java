package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.util.UserPull;

public interface GroupAnswering extends SingleUserAnswering{

    default void sendGroupAnswer(AbsSender absSender, Object group, String text){
        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                sendAnswer(absSender, member.getChatId(), text);
            }
        }
    }
}
