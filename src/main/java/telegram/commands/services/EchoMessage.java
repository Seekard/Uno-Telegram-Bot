package telegram.commands.services;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GroupAnswering;
import telegram.commands.util.UserPull;

public class EchoMessage extends BotCommand implements GroupAnswering {
    public EchoMessage(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        var sender = UserPull.get_or_create(user, chat.getId());
        if (sender.isNotPlaying()) {
            sendGroupAnswer(absSender, this.getCommandIdentifier(), sender.getMembership().getParty(),
                    sender.getUserName() + ": " + strings[0]);
        }
        else {
            sendAnswer(absSender, sender.getChatId(), this.getCommandIdentifier(), sender.getUserName(),
                    "вы не состоите в лобби");
        }
    }
}
