package telegram.commands.operations;


import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.util.UserState;

import static telegram.commands.util.Utils.UserPull;

public class InviteMate extends OperationCommand{


    public InviteMate(String name, String description) {
        super(name, description);
    }

    String getUserNameToInvite(String[] strings){
        if (strings.length == 0) {
            return null;
        }
        else {
            return strings[0];
        }
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {


        String userName = getUserName(user);
        String userNameToInvite = getUserNameToInvite(strings);
        String outputMessage;

        if (userNameToInvite.equals(null)){
            outputMessage = "Не указан пользователь";
        }
        else if (UserPull.get(user).equals(UserState.NotPlaying)){ // write condition about invitor user not having party and not playing
            outputMessage = "Вы не можете пригласить, вы сейчас в активной игре или не состоите ни в одном лобби";
        }
        else {
            outputMessage = "i don't know what should i do";
        }

        // add if statement about invited user not having lobby and not playing so on
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName, outputMessage);
    }
}
