package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GroupAnswering;
import telegram.commands.util.UserPull;
import uno.GameProvider;
import uno.parties.Party;

public class StartMatch extends BotCommand implements GroupAnswering {

    public StartMatch(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params){

        var userPlayer = UserPull.get_or_create(user, chat.getId());
        if (userPlayer.isNotPlaying()){
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(),
                    userPlayer.getUserName(),
                    "Вы не создали игру"
            );
        }
        else {
            Party party = userPlayer.getMembership().getParty();
            try {
                GameProvider gameProvider = new GameProvider(party);
                userPlayer.getMembership().setProvider(gameProvider);
                sendGroupAnswer(absSender, this.getCommandIdentifier(),
                        party,
                        "Игрок: " + userPlayer + " начал игру"
                );
            } catch (Exception e) {
                sendGroupAnswer(absSender, this.getCommandIdentifier(),
                        party,
                        "создать игру не получилось"
                );
                e.printStackTrace(System.out);
            }
        }
    }
}
