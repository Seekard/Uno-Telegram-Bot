package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.Membership;
import telegram.commands.util.KeyBoardSetter;

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
        for (var user: users)
        {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(mainInfo.toString());
            sendMessage.setChatId(user.getChatId().toString());
            KeyBoardSetter.setButtonsIn(sendMessage,user );
            SingleMessageSender.sendMessage(absSender, sendMessage);
        }
    }


}
