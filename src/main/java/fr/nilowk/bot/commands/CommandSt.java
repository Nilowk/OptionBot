package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandSt implements CommandExecutor {

    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor().canManageServer()) {

            if (args.length <= 0) {

                MessageUtils.sendAndDelete(event.getChannel(), "Merci de choisir une fonction à démarrer ou à éteindre parmis la liste suivante :", 10_000);

            } else {

                if (args[0].equalsIgnoreCase("aall")) {

                    CommandClear.activate = true;
                    CommandKick.activate = true;
                    CommandBan.activate = true;
                    CommandAnnonce.activate = true;
                    CommandCconfig.activate = true;
                    CommandNew.activate = true;
                    CommandPlay.activate = true;
                    MessageUtils.sendAndDelete(event.getChannel(), "Toutes les fonctions de ce bot on été activé", 10_000);

                }

                if (args[0].equalsIgnoreCase("oall")) {

                    CommandClear.activate = false;
                    CommandKick.activate = false;
                    CommandBan.activate = false;
                    CommandAnnonce.activate = false;
                    CommandCconfig.activate = false;
                    CommandNew.activate = false;
                    CommandPlay.activate = false;
                    MessageUtils.sendAndDelete(event.getChannel(), "Toutes les fonctions de ce bot on été désactivé", 10_000);

                }

                if (args[0].equalsIgnoreCase("clear")) {

                    if (CommandClear.activate) {

                        CommandClear.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de clear viens d'être désactiver", 10_000);

                    } else {

                        CommandClear.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de clear viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("kick")) {

                    if (CommandKick.activate) {

                        CommandKick.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de kick viens d'être désactiver", 10_000);

                    } else {

                        CommandKick.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de kick viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("ban")) {

                    if (CommandBan.activate) {

                        CommandBan.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de ban viens d'être désactiver", 10_000);

                    } else {

                        CommandBan.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de ban viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("annonce")) {

                    if (CommandAnnonce.activate) {

                        CommandAnnonce.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction d'annonce viens d'être désactiver", 10_000);

                    } else {

                        CommandAnnonce.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction d'annonce viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("cconfig")) {

                    if (CommandCconfig.activate) {

                        CommandCconfig.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de config de channel viens d'être désactiver", 10_000);

                    } else {

                        CommandCconfig.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de config de channel viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("new")) {

                    if (CommandNew.activate) {

                        CommandNew.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de ticket viens d'être désactiver", 10_000);

                    } else {

                        CommandNew.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de ticket viens d'être activer", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("play")) {

                    if (CommandPlay.activate) {

                        CommandPlay.activate = false;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de musique viens d'être désactiver", 10_000);

                    } else {

                        CommandPlay.activate = true;
                        MessageUtils.sendAndDelete(event.getChannel(), "la fonction de musique viens d'être activer", 10_000);

                    }

                }

            }

        } else {

            MessageUtils.sendAndDelete(event.getChannel(), "Vous n'avez pas la permition d'utiliser cette commande", 10_000);

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }

}
