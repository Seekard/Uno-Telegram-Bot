package telegram.commands.services;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.util.Utils;

public class StartCommand extends ServiceCommand {

    public StartCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {

        UserPlayer userPlayer = Utils.UserPull.get(user);

        if (userPlayer == null){
            userPlayer = new UserPlayer(user, chat.getId());
            Utils.UserPull.put(user, userPlayer);
        }
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), getUserName(user),
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }
}
