package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.objects.Chat;

import telegram.commands.util.Utils;
import uno.parties.Party;
import uno.parties.Player;
import telegram.UserPlayer.UserPlayer;

public class CreateParty extends OperationCommand {
    String successMessage = "success message";
    String errorMessage = "error message";

    public CreateParty(String name, String description) {
        super(name, description);
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] params){
        String outputMessage;

        String userName = getUserName(user);

        UserPlayer userPlayer = Utils.UserPull.get(user);

        if (userPlayer == null){
            userPlayer = new UserPlayer(user, chat.getId());
            Utils.UserPull.put(user, userPlayer);
        }

        if (!userPlayer.isPlaying()) {
            Party party = new Party();
            Player player = new Player(userName);
            party.add(player);
            userPlayer.setMembership(party, player);
            outputMessage = this.successMessage;
        } else {
            outputMessage = this.errorMessage;
        }

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
         outputMessage);

    }
}