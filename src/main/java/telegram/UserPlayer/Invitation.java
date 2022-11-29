package telegram.UserPlayer;

public class Invitation {
    private final UserPlayer invitor;
    private final UserPlayer invited;

    public Invitation(UserPlayer invitor, UserPlayer invited){
        this.invited = invited;
        this.invitor = invitor;
    }
    public UserPlayer getInvitor() {
        return invitor;
    }

    public UserPlayer getInvited(){
        return invited;
    }
}
