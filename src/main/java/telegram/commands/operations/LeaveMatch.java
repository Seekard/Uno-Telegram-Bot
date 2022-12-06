package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GroupAnswering;
import telegram.commands.util.UserPull;

public class LeaveMatch extends BotCommand implements GroupAnswering {
    public LeaveMatch(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params){
        var userPlayer = UserPull.get_or_create(user, chat.getId());
        if (userPlayer.isNotPlaying()) {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userPlayer.getUserName(),
                    "Кажется вы и так не состоите в лобби");
        }
        else{
            sendGroupAnswer(absSender, this.getCommandIdentifier(), userPlayer.getMembership().getParty(),
                    "Игрок " + userPlayer.getUserName() + " покинул лобби");
            userPlayer.leaveMembership();
        }
    }
}
