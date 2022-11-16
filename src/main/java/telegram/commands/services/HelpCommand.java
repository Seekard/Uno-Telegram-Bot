package telegram.commands.services;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand extends ServiceCommand {
    public HelpCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {
        String userName = getUserName(user);
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "какой-то вспомогательный текст");
    }
}
