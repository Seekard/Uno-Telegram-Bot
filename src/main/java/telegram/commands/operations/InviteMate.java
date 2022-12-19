package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;


public class InviteMate extends BotCommand {


    public InviteMate(String name, String description) {
        super(name, description);
    }

    String getUserNameToInvite(String[] strings){
        if (strings.length == 0) {
            return null;
        }
        else {
            String result = strings[0];
            if (result.charAt(0) == '@'){
                result = result.substring(1);
            }
            return result;
        }
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userNameToInvite = getUserNameToInvite(strings);
        String outputMessage;

        UserPlayer userPlayer = UserPull.get_or_create(user, chat.getId());

        if (userNameToInvite == null){
            outputMessage = "Не указан пользователь";
        }
        else if (userPlayer.isNotPlaying()){
            outputMessage = "Вы не можете пригласить, пока не создадите лобби";
        }
        else {
            UserPlayer invited = UserPull.selectByTheName(userNameToInvite);

            if (invited == null) {
                outputMessage = "Я не могу пригласить этого человека";
            } else if (invited.isNotPlaying() && !invited.hasInvitation()) {
                invited.setInvitation(userPlayer);
                SingleMessageSender.sendMessage(absSender, invited.getChatId(), this.getCommandIdentifier(), invited.getUserName(),
                        "Пользователь " + userPlayer.getPlayer() + " приглашает вас в лобби");
                outputMessage = "Приглащению пользователю " + userNameToInvite + " отправлено, ожидайте";
            } else {
                outputMessage = "Данный пользователь уже занят";
            }
        }
        SingleMessageSender.sendMessage(absSender, chat.getId(), this.getCommandIdentifier(), userPlayer.getUserName(),
                outputMessage);
    }
}
