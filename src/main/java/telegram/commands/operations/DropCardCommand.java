package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.KeyboardSetupBotCommand;
import telegram.commands.util.UserPull;
import telegram.commands.util.fromStickerId2Card;


public class DropCardCommand extends KeyboardSetupBotCommand{
    public DropCardCommand(String name, String description){
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] params) {

        var userPlayer = UserPull.get_or_create(user, chat.getId());
        String stickerId = fromStickerId2Card.getFromFormatString(params[0]);
        SendSticker sendSticker = new SendSticker();
        InputFile stickerFile = new InputFile(stickerId);
        sendSticker.setSticker(stickerFile);

        sendGroupAnswer(absSender, userPlayer.getMembership().getParty(), sendSticker);
    }

    public void sendGroupAnswer(AbsSender absSender, Object group, SendSticker sendSticker){
        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                sendAnswer(absSender, member.getChatId(), sendSticker, member);
            }
        }
    }

    public void sendAnswer(AbsSender absSender, Long chatId, SendSticker sendSticker, UserPlayer userPlayer){
        sendSticker.setChatId(chatId.toString());
        sendSticker.setReplyMarkup(getButtons(userPlayer));

        try {
            absSender.execute(sendSticker);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
