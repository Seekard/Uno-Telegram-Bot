package telegram.commands.operations;

import telegram.commands.services.ServiceCommand;

public abstract class OperationCommand extends ServiceCommand {
    public OperationCommand(String name, String description){
        super(name, description);
    }
}
