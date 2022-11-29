package telegram.commands.operations;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.util.Utils;
import uno.parties.Party;
import uno.parties.Player;

public class AnswerInvitation extends OperationCommand{
    public AnswerInvitation(String name, String description) {
        super(name, description);
    }


    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        UserPlayer userPlayer = Utils.UserPull.get(user);
        if (userPlayer.hasInvitation()) {
            UserPlayer invitor = userPlayer.getInvitation().getInvitor();
            Party party = invitor.getCurrentParty();
            String invitedName = userPlayer.getUserName();

            if (this.getCommandIdentifier().equals("accept")) {
                for (UserPlayer member: Utils.UserPull.values()) {
                    if (member.getCurrentParty().equals(party)) {
                        sendAnswer(absSender, member.getChatId(), member.getUserName(),
                                this.getCommandIdentifier(),
                                "К вам примоединился новый игрок: " + invitedName);
                    }
                }
                invitor.setMembership(party, new Player(invitedName));

            } else if (this.getCommandIdentifier().equals("refuse")) {
                sendAnswer(absSender, invitor.getChatId(), invitor.getUserName(),
                        this.getCommandIdentifier(),
                        "Отказался от приглашения " + invitedName
                );
            }
        }
        else {
            sendAnswer(absSender, chat.getId(), userPlayer.getUserName(),
                    this.getCommandIdentifier(),
                    "Странно, но у вас нет ни одного приглашения"
            );
        }
    }
}
