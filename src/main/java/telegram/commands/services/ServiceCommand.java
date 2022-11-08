package telegram.commands.services;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


abstract public class ServiceCommand extends BotCommand{
    public ServiceCommand(String name, String description){
        super(name, description);
    }
    protected String getUserName(User user){
        String userName = user.getUserName();
        if (userName == null){
            userName = String.format("%s %s", user.getFirstName(), user.getLastName());
        }
        return userName;
    }

    protected void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text){
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            // do some logs
            e.printStackTrace(System.out);
        }
    }
}
