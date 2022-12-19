package telegram.commands.abstracts;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import telegram.UserPlayer.UserPlayer;

import java.util.ArrayList;


public abstract class KeyboardSetupBotCommand extends BotCommand {

    public KeyboardSetupBotCommand(String name, String description) {
        super(name, description);
    }

    protected ReplyKeyboardMarkup getButtons(UserPlayer userPlayer){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        int k = 1;
        for (var card: userPlayer.getPlayer().getCards()){
            if (k%3 == 0){
                keyboard.add(keyboardRow);
                keyboardRow = new KeyboardRow();
            }
            keyboardRow.add("/drop " + card.toString());
            k++;
        }

        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
