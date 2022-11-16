package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.objects.Chat;

import telegram.commands.util.MatchState;
import telegram.commands.util.Utils;
import telegram.commands.util.UserState;

public class CreateParty extends OperationCommand {
    String successMessage = "success message";
    String errorMessage = "error message";

    public CreateParty(String name, String description) {
        super(name, description);
    }

    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {

        if (Utils.UserPull.get(user.getId().toString()).equals(UserState.NotPlaying)) {
            Utils.MatchPull.put(user.getId().toString(), MatchState.Created);
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), getUserName(user),
                    this.successMessage);
            Utils.UserPull.put(user.getId().toString(), UserState.Playing);
        } else {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), getUserName(user),
                    this.errorMessage);
        }
    }
}