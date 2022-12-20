package telegram.commands.services;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.SingleMessageSender;
import telegram.commands.util.UserPull;

public class StartCommand extends BotCommand {

    public StartCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {

        UserPlayer userPlayer = UserPull.get_or_create(user, chat.getId());
        SingleMessageSender.sendMessage(absSender, chat.getId(),
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }
}
