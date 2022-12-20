package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GameInfoMessageSender;
import telegram.commands.abstracts.GroupMessageSender;
import telegram.commands.abstracts.GroupStickerSender;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;

public class MakeMoveCommand extends BotCommand
{
    public MakeMoveCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings)
    {
        var userPlayer = UserPull.get_or_create(user, chat.getId());
        var player = userPlayer.getPlayer();
        var memberShip = userPlayer.getMembership();
        var gameProvider = memberShip.getProvider();
        var card = gameProvider.getCard(String.join("", strings));
        if (gameProvider.getPlayerWhoseTurn() != player)
        {
            SingleMessageSender.sendMessage(absSender, chat.getId(), "Дружище, сейчас не твой ход");
            return;
        }
        if (card == null)
        {
            SingleMessageSender.sendMessage(absSender, chat.getId(),  "Такой карты нет в игре((9(");
            return;
        }

        if (!player.hasCard(card))
        {
            SingleMessageSender.sendMessage(absSender, chat.getId(),  "У тебя нет такой карты((9(");
            return;
        }
        if (!gameProvider.CouldBePlaced(card))
        {
            SingleMessageSender.sendMessage(absSender, chat.getId(),  "Этой картой нельзя побить текущую карту");
            return;
        }

        gameProvider.makeMove(player, card);
        GroupMessageSender.sendMessage(absSender,  userPlayer.getCurrentParty(),
                player.getName() + " поставил " + card.getName());
        GroupStickerSender.sendSticker(absSender, userPlayer.getCurrentParty(), card.getName());

        if (player.getAmountOfCards() == 0)
        {
            GroupMessageSender.sendMessage(absSender,  userPlayer.getCurrentParty(),
                    player.getName() + " - гений, победил в сломанной игре");
            for (var userInParty: memberShip.getUsers())
            {
                userInParty.setMembership(null);
            }
            return;
        }

        GameInfoMessageSender.sendMessage(absSender, userPlayer.getMembership());
    }
}
