package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandAnnonce implements CommandExecutor {

    public static boolean activate = false;
    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor().canManageServer()) {

            if (args.length < 1) {
                MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir la commande avec la syntaxe suivante -> -annonce message", 10_000);
            } else {

                String message = "";
                int i = 0;

                while (i <= (args.length - 1)) {

                    message = message + " " + args[i];
                    i++;

                }

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("**" + "Annonce :" + "**")
                        .setAuthor(config.serverName, "", config.logoserver)
                        .setDescription(message)
                        .setFooter("By Nilowk")
                        .setTimestampToNow();
                event.getChannel().sendMessage("@everyone", embed);




            }


        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }

}
