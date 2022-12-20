package telegram.commands.util;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import telegram.UserPlayer.UserPlayer;
import java.util.ArrayList;

public class KeyBoardSetter {

    public static void setButtonsIn(SendMessage sendT, UserPlayer userPlayer) {
        sendT.setReplyMarkup(getButtons(userPlayer));
    }

    public static void setButtonsIn(SendSticker sendT, UserPlayer userPlayer) {
        sendT.setReplyMarkup(getButtons(userPlayer));
    }

    private static ReplyKeyboardMarkup getButtons(UserPlayer userPlayer) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        int k = 1;
        for (var card: userPlayer.getPlayer().getCards()){
            keyboardRow.add("/put " + card.getName());
            if (k%3 == 0) {
                keyboard.add(keyboardRow);
                keyboardRow = new KeyboardRow();
            }
            k++;
        }
        if (!keyboardRow.isEmpty()){
            keyboard.add(keyboardRow);
        }
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
