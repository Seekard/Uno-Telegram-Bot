package telegram.commands.util;

import org.telegram.telegrambots.meta.api.objects.User;
import uno.parties.Party;
import uno.parties.Player;
import java.util.HashMap;


public enum Utils {
    Instance;
    public static HashMap<User, UserState> UserPull = new HashMap<>();
    public static HashMap<Player, PlayerState> PlayerPull = new HashMap<>();
    public static HashMap<Party, MatchState> MatchPull = new HashMap<>();
}