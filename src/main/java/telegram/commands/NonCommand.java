package telegram.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.abstracts.GroupAnswering;
import telegram.commands.util.UserPull;
import telegram.commands.util.fromStickerId2Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class NonCommand implements GroupAnswering {

    private final UserPlayer userPlayer;
    private final Message message;

    public NonCommand(Message message, User user, Long chatId){
        this.userPlayer = UserPull.get_or_create(user, chatId);
        this.message = message;
    }

    private void dropCard(String cardIdentifier){

    }

    private void unrecognizedIdentifier(String identifier){

    }

    public SendSticker execute() {

        SendSticker sendSticker = new SendSticker();
        String messageText = message.getText();
        String stickerId = fromStickerId2Card.getFromFormatString(messageText);

        InputFile stickerFile = new InputFile(stickerId);
        sendSticker.setChatId(this.userPlayer.getChatId().toString());
        sendSticker.setSticker(stickerFile);

        setButtons(sendSticker);

        return sendSticker;
    }

    public void setButtons(SendSticker sendSticker){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendSticker.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        var k = 0;
        KeyboardRow keyboardRow = new KeyboardRow();
        Map<String, String> allTypesOfCards = new TreeMap<String, String>(fromStickerId2Card.data);

        for (var card: allTypesOfCards.keySet()){
            keyboardRow.add(card);
            k++;
            if (k%3 == 0) {
                keyboard.add(keyboardRow);
                keyboardRow = new KeyboardRow();
            }
        }

        for (int i = 0; i < this.userPlayer.getPlayer().getAmountOfCards(); ++i) {
            keyboardRow = new KeyboardRow();
            for (int j = i; j < i + 3; ++j){
                var card = this.userPlayer.getPlayer().getCards().get(j);
                keyboardRow.add(card.toString());
            }
            keyboard.add(keyboardRow);
        }

        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
