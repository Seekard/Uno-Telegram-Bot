package telegram.UserPlayer;

import uno.GameProvider;
import uno.parties.Party;

public class Membership {
    private final Party party;
    private GameProvider provider;

    public Membership(Party party) {
        this.party = party;
        this.provider = null;
    }

    public Party getParty() {
        return this.party;
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