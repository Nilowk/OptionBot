package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandClear implements CommandExecutor {

    public static boolean activate = false;
    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor().canManageMessagesInTextChannel()) {

            if (activate) {

                if (args.length <= 0) {

                    MessageUtils.sendAndDelete(event.getChannel(), "Merci d'indiquer un nombre de messages à supprimer", 10_000);

                } else {

                    try {

                        int delnumber = Integer.parseInt(args[0]);
                        if (delnumber < 1 || delnumber > 99) {

                            MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir un nombre compris entre 1 et 99", 10_000);

                        } else {

                            event.getChannel().getMessages(delnumber).thenAcceptAsync(msg -> {
                                event.getChannel().bulkDelete(msg).thenAcceptAsync(msgReply -> {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Vous avez supprimé " + (msg.size()) + " messages", 10_000);
                                });
                            });

                        }

                    } catch (NumberFormatException e) {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir un nombre valide compris entre 1 et 99", 10_000);

                    }

                }

            } else {

                MessageUtils.sendAndDelete(event.getChannel(), "cette commande est désactivé, pour l'activer il faut utiliser la commande: -st clear", 10_000);

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
