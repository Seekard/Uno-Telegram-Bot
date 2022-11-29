package telegram.commands.util;

import org.telegram.telegrambots.meta.api.objects.User;

import telegram.UserPlayer.UserPlayer;

import java.util.HashMap;

public enum Utils {
    Instance;
    public static HashMap<User, UserPlayer> UserPull = new HashMap<>();
}
