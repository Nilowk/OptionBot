package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandStopBot implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor() == event.getServer().get().getMemberById("402065040280387604").get()) {

            System.exit(0);

        }

    }

    @Override
    public void theDescription(Command command) {

    }
}
