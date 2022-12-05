package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.objects.Chat;

import telegram.UserPlayer.Membership;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.SingleUserAnswering;
import telegram.commands.util.UserPull;
import uno.parties.Party;
import uno.parties.Player;

public class CreateParty extends BotCommand implements SingleUserAnswering {
    String successMessage = "success message";
    String errorMessage = "error message";

    public CreateParty(String name, String description) {
        super(name, description);
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] params){
        String outputMessage;
        UserPlayer userPlayer = UserPull.get_or_create(user, chat.getId());
        String userName = userPlayer.getUserName();

        if (userPlayer.isNotPlaying()) {
            Party party = new Party();
            Player player = new Player(userName);
            party.add(player);
            userPlayer.setMembership(new Membership(party));
            outputMessage = this.successMessage;
        } else {
            outputMessage = this.errorMessage;
        }

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
         outputMessage);

    }
}