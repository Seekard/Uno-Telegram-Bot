package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.GroupAnswering;
import telegram.commands.abstracts.KeyboardSetupBotCommand;
import telegram.commands.util.UserPull;
import uno.GameProvider;
import uno.parties.Party;

public class StartMatch extends KeyboardSetupBotCommand implements GroupAnswering {
    UserPlayer userPlayer = null;
    public StartMatch(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params){

        userPlayer = UserPull.get_or_create(user, chat.getId());
        if (userPlayer.isNotPlaying()){
            sendAnswer(absSender, chat.getId(),
                    "Вы не создали игру"
            );
        }
        else {
            Party party = userPlayer.getMembership().getParty();
            try {
                GameProvider gameProvider = new GameProvider(party);
                userPlayer.getMembership().setProvider(gameProvider);
                sendGroupAnswer(absSender,
                        party,
                        "Игрок: " + userPlayer + " начал игру"
                );
            } catch (Exception e) {
                sendGroupAnswer(absSender,
                        party,
                        "создать игру не получилось"
                );
                e.printStackTrace(System.out);
            }
        }
    }
    public void sendAnswer(AbsSender absSender, Long chatId, String text){
        SendMessage message = new SendMessage();

        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        message.setReplyMarkup(getButtons(userPlayer));
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
