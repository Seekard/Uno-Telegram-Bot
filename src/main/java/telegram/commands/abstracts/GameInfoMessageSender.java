package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.Membership;

public class GameInfoMessageSender
{
    public static void sendMessage(AbsSender absSender, Membership membership)
    {
        var users = membership.getUsers();
        var gameProvider = membership.getProvider();
        var mainInfo = new StringBuilder();
        mainInfo.append("Сейчас ходит ").append(gameProvider.getPlayerWhoseTurn().getName()).append('\n');
        for (var user: users)
        {
            var player = user.getPlayer();
            var amountOfCards = player.getAmountOfCards();
            mainInfo.append(player.getName()).append(": ").append(amountOfCards).append('\n');
        }
        System.out.println("info ahhahaha:" + mainInfo);
        for (var user: users)
        {
            var message = new StringBuilder(mainInfo);
            var player = user.getPlayer();
            message.append("Твои карты:\n");
            for (var card: player.getCards())
            {
                message.append(card.getName()).append('\n');
            }
            SingleMessageSender.sendMessage(absSender, user.getChatId(), "", "", message.toString());
        }
    }
}
