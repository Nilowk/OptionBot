package fr.nilowk.bot.utils.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.commands.*;
import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;

public class MessageManager {

    public static CommandRegistry registry = new CommandRegistry();
    public static Config config = new Config();

    static {
        registry.addCommand(new Command(
                "config",
                "cette commande permet de configurer de a à z le bot (commande admin)",
                new CommandConfig(),
                "config", "config"
        ));
        registry.addCommand(new Command(
                "st",
                "cette commande permet de démarrer ou d'éteindre une fonction de ce bot (commande admin)",
                new CommandSt(),
                "st", "s"
        ));
        registry.addCommand(new Command(
                "help",
                "cette commande permet de lister les commandes disponible ",
                new CommandHelp(),
                "help", "h"
        ));
        registry.addCommand(new Command(
                "clear",
                "cette commande permet de supprimer un certain nombre de messages (commande modo)",
                new CommandClear(),
                "clear", "cl"
        ));
        registry.addCommand(new Command(
                "warn",
                "cette commande permet de warn une personne au besoin (commande modo)",
                new CommandWarn(),
                "warn", "w"
        ));
        registry.addCommand(new Command(
                "kick",
                "cette commande permet de kick une personne du discord (commande modo)",
                new CommandKick(),
                "kick", "k"
        ));
        registry.addCommand(new Command(
                "ban",
                "cette commande permet de bannir définitivement un utilisateur du discord (commande modo)",
                new CommandBan(),
                "ban", "b"
        ));
        registry.addCommand(new Command(
                "annonce",
                "cette commande permet de faire une annonce stylisé (commande admin)",
                new CommandAnnonce(),
                "annonce", "a"
        ));
        registry.addCommand(new Command(
                "cconfig",
                "cette commande permet de configurer son channel",
                new CommandCconfig(),
                "cconfig", "cc"
        ));
        registry.addCommand(new Command(
                "close",
                "cette commande permet de fermer un ticket",
                new CommandClose(),
                "close", "c"
        ));
        registry.addCommand(new Command(
                "rules",
                "cette command permet d'afficher le règlement au besoin",
                new CommandRules(),
                "rules", "r"
        ));
        registry.addCommand(new Command(
                "play",
                "cette commande permet d'écouter de la musique",
                new CommandPlay(),
                "play", "p"
        ));
        registry.addCommand(new Command(
                "stopbot",
                "",
                new CommandStopBot(),
                "stopbot", "sb"
        ));
    }

    public static void create(MessageCreateEvent event) {

       // if (event.isPrivateMessage()) {

            /*if (event.getMessage().getContent().startsWith(config.prefix + "new")) {

                String[] args = event.getMessage().getContent().split(" ");
                args = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);
                String[] finalArgs = args;
                CommandNew.run(event, config, finalArgs);

            } else {

                for (ServerTextChannel channel : event.getApi().getServerById(config.serverId).get().getTextChannels()) {

                    if (channel.getName().startsWith("🧾ticket-") && channel.getTopic().equalsIgnoreCase("" + event.getMessageAuthor().getId())) {

                        String message = "";
                        String[] args = event.getMessage().getContent().split(" ");
                        int i = 0;
                        while (i < args.length) {

                            message = message + args[i] + " ";
                            i++;

                        }
                        channel.sendMessage(message);
                    }

                    

                }

                if (event.getServer().get().getTextChannelById(event.getChannel().getId()).get().getName().startsWith("🧾ticket-")) {

                    String message = "";
                    String[] args = event.getMessage().getContent().split(" ");
                    int i = 0;
                    while (i < args.length) {

                        message = message + args[i] + " ";
                        i++;

                    }
                    event.getServer().get().getMemberById(event.getServer().get().getTextChannelById(event.getChannel().getId()).get().getTopic()).get().sendMessage(message);

                }


            }*/

        //} else if (event.getMessageContent().startsWith(config.prefix)) {

            if (event.getServer().get().getId() == 862745444755963924l) {
                if (event.getChannel().getId() != 876909718415749130l) {
                    event.getServer().get().getTextChannelById("876909718415749130").get().sendMessage(event.getServer().get().getTextChannelById(event.getChannel().getId()).get().getName() + " : \n" + "**" + event.getMessageAuthor().getName() + "** \n" + event.getMessageContent());
                }

            }
          /*  String[] args = event.getMessageContent().split(" ");
            String commandName = args[0].substring(config.prefix.length());
            args = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);

            String[] finalArgs = args;
            registry.getByAlias(commandName).ifPresent((cmd -> {
                cmd.getExecutor().run(event, config, cmd, finalArgs);
            }));*/
       // }


    }

}
