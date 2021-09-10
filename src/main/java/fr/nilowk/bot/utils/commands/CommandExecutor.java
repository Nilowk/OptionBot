package fr.nilowk.bot.utils.commands;

import fr.nilowk.bot.utils.Config;
import org.javacord.api.event.message.MessageCreateEvent;

public interface CommandExecutor {

    void run(MessageCreateEvent event, Config config, Command command, String[] args);

    void theDescription(Command command);

}
