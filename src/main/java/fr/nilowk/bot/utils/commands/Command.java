package fr.nilowk.bot.utils.commands;

public class Command {

    private String id, description;
    private String[] aliases;
    private CommandExecutor executor;

    public Command(String id, String descrition, CommandExecutor executor, String... aliases) {
        this.id = id;
        this.description = descrition;
        this.aliases = aliases;
        this.executor = executor;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAliases() {
        return aliases;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

}
