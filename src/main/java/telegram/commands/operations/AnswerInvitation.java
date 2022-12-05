package telegram.commands.operations;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import telegram.UserPlayer.UserPlayer;
import telegram.commands.util.UserPull;
import telegram.commands.abstracts.GroupAnswering;
import uno.parties.Party;
import uno.parties.Player;


public class AnswerInvitation extends BotCommand implements GroupAnswering {
    public AnswerInvitation(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        UserPlayer invited = UserPull.get_or_create(user, chat.getId());

        if (invited.hasInvitation()) {
            UserPlayer invitor = invited.getInvitation().getInvitor();
            Party party = invitor.getCurrentParty();
            String invitedName = invited.getUserName();

            if (this.getCommandIdentifier().equals("accept")) {

                invited.setMembership(invitor.getMembership());
                sendGroupAnswer(absSender, this.getCommandIdentifier(), party,
                        "К вам вступил новый пользователь" + invitedName);

            } else if (this.getCommandIdentifier().equals("refuse")) {
                sendAnswer(absSender, invitor.getChatId(), invitor.getUserName(),
                        this.getCommandIdentifier(),
                        "Отказался от приглашения " + invitedName
                );
            }
        }
        else {
            sendAnswer(absSender, chat.getId(), invited.getUserName(),
                    this.getCommandIdentifier(),
                    "Странно, но у вас нет ни одного приглашения"
            );
        }
    }
}
