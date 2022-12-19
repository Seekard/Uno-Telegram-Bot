package telegram.UserPlayer;

import org.telegram.telegrambots.meta.api.objects.User;
import uno.GameProvider;
import uno.parties.Party;
import uno.parties.Player;

public class UserPlayer {
    private final User user;
    private final Long chatId;
    private Player player;
    private Membership membership;
    private Invitation invitation;
    public UserPlayer(User user, Long chatId){
        this.user = user;
        this.chatId = chatId;
        this.player = new Player(this.getUserName());

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

    public boolean isNotPlaying() {
        return this.membership == null;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
        if (membership == null)
        {
            player = null;
            invitation = null;
            return;
        }
        player = new Player(this.getUserName());
        membership.getUsers().add(this);
        membership.getParty().add(player);
        this.membership = membership;
    }
    public Membership getMembership(){
        return this.membership;
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
    public Player getPlayer(){
        return this.player;
    }

    public void leaveMembership() {
        this.membership.getParty().surrender(this.player);
        this.membership = null;
    }
}
