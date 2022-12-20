package telegram.commands.abstracts;

import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.commands.util.KeyBoardSetter;
import telegram.commands.util.UserPull;
import telegram.commands.util.fromCardStringToId;

public class GroupStickerSender {
    public static void sendSticker(AbsSender absSender, Object group, String cardIdentifier){

        SendSticker sendSticker = new SendSticker();
        String stickerId = fromCardStringToId.getFromFormatString(cardIdentifier);
        InputFile stickerFile = new InputFile(stickerId);
        sendSticker.setSticker(stickerFile);

        for (var member: UserPull.pull.values()) {
            if (member.getCurrentParty().equals(group)) {
                KeyBoardSetter.setButtonsIn(sendSticker, member);
                sendSticker.setChatId(member.getChatId().toString());
                try{
                    absSender.execute(sendSticker);
                }
                catch (TelegramApiException e){
                    e.printStackTrace(System.out);
                }
            }
        }
    }
}
