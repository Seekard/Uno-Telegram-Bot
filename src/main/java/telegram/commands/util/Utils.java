package telegram.commands.util;

import java.util.HashMap;

public enum Utils {
    Instance;
    public static HashMap<String, UserState> UserPull = new HashMap<>();
    public static HashMap<String, PlayerState> PlayerPull = new HashMap<>();
    public static HashMap<String, MatchState> MatchPull = new HashMap<>();
}