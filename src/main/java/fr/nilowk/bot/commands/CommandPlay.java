package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.event.message.MessageCreateEvent;

import java.net.Socket;

public class CommandPlay implements CommandExecutor {

    public static boolean activate = false;
    public static boolean connected = false;
    public static ServerVoiceChannel channel;
    public static String description = "";
    public static boolean onPlay = false;

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (activate) {

            if (event.getMessageAuthor().getConnectedVoiceChannel().isPresent()) {

                if (args.length >= 1) {

                    String search = "";
                    channel = event.getMessageAuthor().getConnectedVoiceChannel().get();
                    int i = 0;
                    while (i <= (args.length - 1)) {

                        search = search + "+" + args[i];
                        i++;

                    }

                    String requete = "https://www.youtube.com/results?search_query=" + search;

                    if (!connected) {

                        channel.connect().thenAccept(audioConnection -> {

                            connected = true;
                            MessageUtils.sendAndDelete(event.getChannel(), "bot connecter", 10_000);

                        }).exceptionally(e -> {
                            e.printStackTrace();

                            return null;
                        });

                    } else if (event.getMessageAuthor().canManageServer()) {

                        channel.connect().thenAccept(audioConnection -> {

                            connected = true;
                            MessageUtils.sendAndDelete(event.getChannel(), "bot connecter", 10_000);

                        }).exceptionally(e -> {
                            e.printStackTrace();

                            return null;
                        });

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "le bot est déjà en cour d'utilisation", 10_000);

                    }

                } else {

                    MessageUtils.sendAndDelete(event.getChannel(), "Merci de choisir une musique", 10_000);

                }

            } else {

                MessageUtils.sendAndDelete(event.getChannel(), "Vous n'êtes pas connecter dans un channel vocal", 10_000);

            }

        } else {

            MessageUtils.sendAndDelete(event.getChannel(), "Cette commande n'est pas activé", 10_000);

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }
}
