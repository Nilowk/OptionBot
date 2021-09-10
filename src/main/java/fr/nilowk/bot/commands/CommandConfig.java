package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;

public class CommandConfig implements CommandExecutor {

    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (args.length <= 0) {

            MessageUtils.sendAndDelete(event.getChannel(), "Merci de choisir une fonction à configurer", 10_000);

        } else {

            if (event.getMessageAuthor().canManageServer()) {

                if (args[0].equalsIgnoreCase("servername")) {

                    if (args.length >= 2) {

                        String name = "";
                        int i = 0;
                        while (i <= (args.length - 1)) {
                            if (i == 0) {
                                i++;
                            }
                            name = name + args[i] + " ";
                            i++;
                        }

                        config.serverName = name;
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit le nom du serveur en : " + name, 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir le nouveaux nom du server", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("logoserver")) {

                    if (args.length >= 2) {

                        config.logoserver = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit le logo du server en : " + event.getChannel().sendMessage(config.logoserver) + " comme étant un créateur de channel", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'url du logo du server", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("prefix")) {

                    if (args.length >= 2) {

                        config.prefix = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit le préfix du bot en : " + args[1], 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir le nouveaux prefix du bot", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("channelcreater")) {

                    if (args.length >= 2) {

                        config.channelcreater = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit le channel : " + event.getServer().get().getVoiceChannelById(args[1]).get().getName() + " comme étant un créateur de channel", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id du channel, pour trouver l'id du channel il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("channelcategory")) {

                    if (args.length >= 2) {

                        config.channelcategory = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit la category : " + event.getServer().get().getChannelCategoryById(args[1]).get().getName() + " comme étant une catégorie de channel personelle", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id de la catégorie, pour trouver l'id de la catégorie il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("ticketcategory")) {

                    if (args.length >= 2) {

                        config.ticketcategory = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit la category : " + event.getServer().get().getChannelCategoryById(args[1]).get().getName() + " comme étant une catégorie de ticket", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id de la catégorie, pour trouver l'id de la catégorie il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("serverid")) {

                    if (args.length >= 2) {

                        config.serverId = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit l'id du server", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id du server, pour trouver l'id du server il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("welcomechannel")) {

                    if (args.length >= 2) {

                        Config.welcomechannel = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit l'id du channel de bienvenue", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id du channel de bienvenue, pour trouver l'id du server il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("rolemember")) {

                    if (args.length >= 2) {

                        Config.memberRole = args[1];
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez définit l'id du role membre", 10_000);

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "Merci de spécifier l'id du role membre, pour trouver l'id du server il faut activer le mode développeur et copier l'identifiant", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("skylize")) {

                    config.serverId = "793504580217339974";
                    config.ticketcategory = "812620778527784960";
                    config.logoserver = "https://i.postimg.cc/g2QYSZr3/logo.png";
                    config.channelcategory = "794598385575264286";
                    config.channelcreater = "817464610193539092";
                    config.serverName = "Skylize RP";
                    Config.welcomechannel = "794584761007734784";
                    Config.memberRole = "795230902753427457";
                    config.warncategory = "828262215760085033";

                }

                if (args[0].equalsIgnoreCase("test")) {

                    config.serverId = "826489725149118565";
                    config.ticketcategory = "828154303709315112";
                    config.logoserver = "https://i.postimg.cc/g2QYSZr3/logo.png";
                    config.channelcategory = "826489725636313128";
                    config.channelcreater = "826866375364444211";
                    config.serverName = "test bot";
                    Config.welcomechannel = "828185053162242059";
                    Config.memberRole = "828194007577526282";
                    config.warncategory = "826869977793036328";

                }

            } else {

                MessageUtils.sendAndDelete(event.getChannel(), "Vous n'avez pas la permition d'utiliser cette commande", 10_000);

            }

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }

}
