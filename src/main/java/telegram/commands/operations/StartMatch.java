package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.abstracts.GroupMessageSender;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;
import uno.GameProvider;
import uno.parties.Party;

public class StartMatch extends BotCommand {

    public StartMatch(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params){

        var userPlayer = UserPull.get_or_create(user, chat.getId());
        if (userPlayer.isNotPlaying()){
            SingleMessageSender.sendMessage(absSender, chat.getId(), this.getCommandIdentifier(),
                    userPlayer.getUserName(),
                    "Вы не создали игру"
            );
        }
        else {
            Party party = userPlayer.getMembership().getParty();
            try {
                GameProvider gameProvider = new GameProvider(party, 1);
                userPlayer.getMembership().setProvider(gameProvider);
                GroupMessageSender.sendMessage(absSender, this.getCommandIdentifier(),
                        party,
                        "Игрок: " + userPlayer.getPlayer().getName() + " начал игру"
                );
            } catch (Exception e) {
                GroupMessageSender.sendMessage(absSender, this.getCommandIdentifier(),
                        party,
                        "создать игру не получилось"
                );
                e.printStackTrace(System.out);
            }
        }
    }
}
