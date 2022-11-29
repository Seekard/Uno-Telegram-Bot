package telegram.commands.operations;


import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import telegram.UserPlayer.UserPlayer;
import telegram.commands.util.Utils;

public class InviteMate extends OperationCommand{


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

        UserPlayer userPlayer = Utils.UserPull.get(user);

        if (userPlayer == null){
            userPlayer = new UserPlayer(user, chat.getId());
        }

        if (userNameToInvite == null){
            outputMessage = "Не указан пользователь";
        }
        else if (!userPlayer.isPlaying()){
            outputMessage = "Вы не можете пригласить, пока не создадите лобби";
        }
        else {
            UserPlayer invited = null;
            outputMessage = "Приглащению пользователю " + userNameToInvite + " отправлено, ожидайте";

            for (var value: Utils.UserPull.values()){

                if (value.getUserName().equals(userNameToInvite)){
                    invited = value;
                    if (!value.isPlaying()) {
                        invited.setInvitation(userPlayer);
                    }
                    else {
                        outputMessage = "Данный пользователь уже занят";
                    }
                }
            }

            if (invited == null){
                outputMessage = "Я не могу пригласить этого человека";
            }
        }
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userPlayer.getUserName(),
                outputMessage);
    }
}
