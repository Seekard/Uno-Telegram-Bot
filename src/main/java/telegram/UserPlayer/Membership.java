package telegram.UserPlayer;

import org.telegram.telegrambots.meta.api.objects.User;
import uno.GameProvider;
import uno.parties.Party;

import java.util.ArrayList;
import java.util.List;

public class Membership {
    private final Party party;
    private final List<UserPlayer> users = new ArrayList<>();
    private GameProvider provider;

    public Membership(Party party) {
        this.party = party;
        this.provider = null;
    }

    public Party getParty() {
        return this.party;
    }
    public List<UserPlayer> getUsers()
    {
        return users;
    }
    public void setProvider(GameProvider provider){
        this.provider = provider;
    }

    public GameProvider getProvider(){
        return this.provider;
    }

    public boolean isGameStarted(){
        return this.provider != null;
    }
}