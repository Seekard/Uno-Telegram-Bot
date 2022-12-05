package telegram.bot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.*;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import telegram.commands.operations.*;
import telegram.commands.services.HelpCommand;
import telegram.commands.services.StartCommand;

public class Bot extends TelegramLongPollingCommandBot
{
    private final String BOT_TOKEN;
    private final String BOT_NAME;

    public Bot(String botName, String botToken){
        super();
        this.BOT_NAME = botName;
        this.BOT_TOKEN = botToken;

        register(new StartCommand("start", "Старт"));
        register(new HelpCommand("help", "Справка"));
        register(new CreateParty("create", "Создать лобби"));
        register(new InviteMate("invite", "Пригласить человека"));
        register(new AnswerInvitation("accept", "Принять приглашение"));
        register(new AnswerInvitation("refuse", "Отказаться от приглашения"));
        register(new StartMatch("startmatch", "Начать игру"));
        register(new LeaveMatch("leave", "Покинуть игру"));
    }
    public String getBotUsername(){
        return BOT_NAME;
    }
    @Override
    public String getBotToken(){
        return BOT_TOKEN;
    }

    @Override
    public void processNonCommandUpdate(Update update){
        Message message = update.getMessage();
        Long chatId = message.getChatId();

        String userName = getUserName(message);
    }

    private String getUserName(Message msg){
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}