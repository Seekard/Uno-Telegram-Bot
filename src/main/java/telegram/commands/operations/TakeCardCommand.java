package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GameInfoMessageSender;
import telegram.commands.util.UserPull;

public class TakeCardCommand extends BotCommand {
    public TakeCardCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        var userPlayer = UserPull.get_or_create(user, chat.getId());
        var player = userPlayer.getPlayer();
        userPlayer.getMembership().getProvider().giveRandomCard(player);
        GameInfoMessageSender.sendMessage(absSender, userPlayer.getMembership());
    }
}
