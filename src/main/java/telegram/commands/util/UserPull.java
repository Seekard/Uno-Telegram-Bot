package telegram.commands.util;

import org.telegram.telegrambots.meta.api.objects.User;
import telegram.UserPlayer.UserPlayer;

import java.util.HashMap;

public enum UserPull {
    Instance;
    public static HashMap<User, UserPlayer> pull = new HashMap<>();
    public static UserPlayer get_or_create(User user, Long chatId){
        UserPlayer value = pull.get(user);
        if (value == null){
            value = new UserPlayer(user, chatId);
            pull.put(user, value);
        }
        return value;
    }

    public static UserPlayer selectByTheName(String userName){
        for (var value: pull.values()){
            if (value.getUserName().equals(userName)){
                return value;
            }
        }
        return null;
    }
}
