package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.objects.Chat;

import telegram.UserPlayer.Membership;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.GameInfoMessageSender;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;
import uno.parties.Party;
import uno.parties.Player;

public class GiveInfoCommand extends BotCommand
{

    public GiveInfoCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings)
    {
        var userPlayer = UserPull.get_or_create(user, chat.getId());
        var membersShip = userPlayer.getMembership();
        GameInfoMessageSender.sendMessage(absSender, membersShip);
    }
}
