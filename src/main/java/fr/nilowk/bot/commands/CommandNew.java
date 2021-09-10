package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandNew {

    public static boolean activate = true;
    public static String description = "";

    public static void run(MessageCreateEvent event, Config config, String[] args) {

        if (activate) {

            if (event.getApi().getServerById(config.serverId).get().getTextChannels().stream().anyMatch(channel -> channel.getName().startsWith("🧾ticket-") && channel.getTopic().equalsIgnoreCase("" + event.getMessageAuthor().getId()))) {

               event.getChannel().sendMessage("Vous avez déjà un ticket d'ouvert");

            } else {

                new ServerTextChannelBuilder(event.getApi().getServerById(config.serverId).get())
                        .setName("🧾ticket-" + event.getMessageAuthor().getName() + "🧾")
                        .setCategory(event.getApi().getServerById(config.serverId).get().getChannelCategoryById(config.ticketcategory).get())
                        .setTopic("" + event.getMessageAuthor().getId())
                        .create().thenAcceptAsync(channel -> {
                    if (args.length > 0) {

                        String message = "";
                        int i = 0;
                        while (i < args.length) {

                            message = message + args[i] + " ";
                            i++;

                        }
                        channel.sendMessage(message);

                    }
                    event.getChannel().sendMessage("votre ticket à bien été ouvert merci de nous décrire votre probleme si cela n'est pas encore fait");
                });

            }

        } else {

            event.getChannel().sendMessage("les tickets sont désactiver pour le moment");

        }

    }

    public static void theDescription() {
        description = "cette commande permet de crée un ticket";
    }
}
