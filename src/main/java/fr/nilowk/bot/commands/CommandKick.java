package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandKick implements CommandExecutor {

    public static boolean activate = false;
    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor().canKickUsersFromServer()) {

            if (activate) {

                if (args.length <= 0) {

                    MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir un personne à kick du server", 10_000);

                } else {

                    event.getMessage().getMentionedUsers().get(0).sendMessage("Vous avez été kick de " + config.serverName);
                    event.getServer().get().kickUser(event.getMessage().getMentionedUsers().get(0));

                }

            } else {

                MessageUtils.sendAndDelete(event.getChannel(), "cette commande est désactivé, pour l'activer il faut utiliser la commande: -st kick", 10_000);

            }

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }

}
