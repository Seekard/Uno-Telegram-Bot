package telegram.UserPlayer;

import org.telegram.telegrambots.meta.api.objects.User;
import uno.parties.Party;
import uno.parties.Player;

public class UserPlayer {

    private class Membership {
        private final Party party;
        private final Player player;

        private Membership(Party _party, Player _player) {
            this.party = _party;
            this.player = _player;
        }

        public Party getParty() {
            return this.party;
        }

        public Player getPlayer(){
            return this.player;
        }
    }

    private final User user;
    private final Long chatId;
    private Membership membership;
    private Invitation invitation;

    public UserPlayer(User user, Long chatId){
        this.user = user;
        this.chatId = chatId;
        this.membership = null;
        this.invitation = null;
    }
    public String getUserName(){
        String userName = user.getUserName();
        if (userName == null){
            userName = String.format("%s %s", user.getFirstName(), user.getLastName());
        }
        return userName;
    }

    public Party getCurrentParty() {
        return this.membership.getParty();
    }

    public Long getChatId() {
        return chatId;
    }

    public boolean isPlaying() {
        return this.membership != null;
    }

    public void setMembership(Party party, Player player) {
        this.membership = new Membership(party, player);
    }

    public Invitation getInvitation(){
        return this.invitation;
    }

    public boolean hasInvitation(){
        return this.invitation != null;
    }

    public void setInvitation(UserPlayer invitor){
        this.invitation = new Invitation(invitor, this);
    }
}
