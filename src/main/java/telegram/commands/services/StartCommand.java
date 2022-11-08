package telegram.commands.services;

import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.commands.util.UserState;
import telegram.commands.util.Utils;

public class StartCommand extends ServiceCommand {

    public StartCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {
        if (!Utils.UserPull.containsKey(user.getId().toString())){
            Utils.UserPull.put(user.getId().toString(), UserState.NotPlaying);
        }

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), getUserName(user),
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }
}
