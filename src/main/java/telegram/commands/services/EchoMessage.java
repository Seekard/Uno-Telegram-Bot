package telegram.commands.services;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GroupMessageSender;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;

public class EchoMessage extends BotCommand {
    public EchoMessage(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        var sender = UserPull.get_or_create(user, chat.getId());
        if (sender.isNotPlaying()) {
            GroupMessageSender.sendMessage(absSender, sender.getMembership().getParty(),
                    sender.getUserName() + ": " + strings[0]);
        }
        else {
            SingleMessageSender.sendMessage(absSender, sender.getChatId(),"вы не состоите в лобби");
        }
    }
}
