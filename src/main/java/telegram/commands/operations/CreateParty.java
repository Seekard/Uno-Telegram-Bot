package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.objects.Chat;

import telegram.commands.util.Utils;
import telegram.commands.util.UserState;
import telegram.commands.util.PlayerState;
import uno.parties.Party;
import uno.parties.Player;

public class CreateParty extends OperationCommand {
    String successMessage = "success message";
    String errorMessage = "error message";

    public CreateParty(String name, String description) {
        super(name, description);
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {
        // TODO:
        // command creates new party(lobby) and sends information about success or error
        // also creates new Player from User and adds to new lobby
        String outputMessage;

        String userName = getUserName(user);

        if (!Utils.UserPull.containsKey(user)){
            Utils.UserPull.put(user, UserState.NotPlaying);
        }

        if (Utils.UserPull.get(user).equals(UserState.NotPlaying)) {
            Utils.UserPull.put(user, UserState.Playing);
            Party party = new Party();
            Player player = new Player(userName);
            party.add(player);
            Utils.PlayerPull.put(player, PlayerState.Null);
            Utils.UserPull.put(user, UserState.Playing);
            outputMessage = this.successMessage;
        } else {
            outputMessage = this.errorMessage;
        }

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
         outputMessage);

    }
}