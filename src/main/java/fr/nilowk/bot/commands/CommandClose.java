package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandClose implements CommandExecutor {

    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        if (CommandNew.activate) {

            if (event.getServer().get().getTextChannelById(event.getChannel().getId()).get().getName().startsWith("🧾ticket-") || event.getServer().get().getTextChannelById(event.getChannel().getId()).get().getTopic().equalsIgnoreCase("" + event.getMessageAuthor().getId())) {

                long channel = event.getChannel().getId();
                event.getServer().get().getTextChannelById(channel).get().delete();

            }

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }
}
