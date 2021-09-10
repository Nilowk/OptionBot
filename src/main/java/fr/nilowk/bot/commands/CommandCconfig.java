package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Optional;

public class CommandCconfig implements CommandExecutor {

    private static String name = "";
    public static boolean activate = false;
    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();

        if (event.getMessageAuthor().getConnectedVoiceChannel().isPresent()) {

            if (args.length < 1) {
                MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir une option : wl, bl, name ou op", 10_000);
            } else if (event.getMessageAuthor().getConnectedVoiceChannel().get().canCreateInstantInvite(event.getMessageAuthor().asUser().get())) {

                if (args[0].equalsIgnoreCase("wl")) {

                    if (args.length >= 1) {

                        Optional<ServerVoiceChannel> channel = event.getMessageAuthor().getConnectedVoiceChannel();

                        if (args.length == 1) {
                            channel.ifPresent(c -> {
                                channel.get().createUpdater()
                                        .addPermissionOverwrite(
                                                event.getServer().get().getEveryoneRole(),
                                                new PermissionsBuilder()
                                                        .setDenied(PermissionType.CONNECT)
                                                        .build()
                                        )
                                        .addPermissionOverwrite(
                                                event.getMessageAuthor().asUser().get(),
                                                new PermissionsBuilder()
                                                        .setAllowed(PermissionType.CONNECT)
                                                        .build()
                                        )
                                        .update();
                                MessageUtils.sendAndDelete(event.getChannel(), "Vous venez de white list votre channel", 10_000);
                            });
                        } else {

                            if (args[1].equalsIgnoreCase("stop")) {

                                channel.ifPresent(c -> {
                                    channel.get().createUpdater()
                                            .addPermissionOverwrite(
                                                    event.getServer().get().getEveryoneRole(),
                                                    new PermissionsBuilder()
                                                            .setAllowed(PermissionType.CONNECT)
                                                            .build()
                                            )
                                            .update();
                                    MessageUtils.sendAndDelete(event.getChannel(), "vous avez stopez la white list", 10_000);
                                });

                            } else {

                                channel.ifPresent(c -> {
                                    channel.get().createUpdater()
                                            .addPermissionOverwrite(
                                                    event.getMessage().getMentionedUsers().get(0),
                                                    new PermissionsBuilder()
                                                            .setAllowed(PermissionType.CONNECT)
                                                            .build()
                                            )
                                            .addPermissionOverwrite(
                                                    event.getMessageAuthor().asUser().get(),
                                                    new PermissionsBuilder()
                                                            .setAllowed(PermissionType.CONNECT)
                                                            .build()
                                            )
                                            .addPermissionOverwrite(
                                                    event.getServer().get().getEveryoneRole(),
                                                    new PermissionsBuilder()
                                                            .setDenied(PermissionType.CONNECT)
                                                            .build()
                                            )
                                            .update();
                                    MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur : " + event.getMessage().getMentionedUsers().get(0).getName() + " à été ajouter à la white list", 10_000);
                                });
                            }
                        }

                    }
                }

                if (args[0].equalsIgnoreCase("bl")) {

                    if (args.length >= 2) {

                        Optional<ServerVoiceChannel> channel = event.getMessageAuthor().getConnectedVoiceChannel();

                        channel.ifPresent(c -> {
                            channel.get().createUpdater()
                                    .addPermissionOverwrite(
                                            event.getMessage().getMentionedUsers().get(0),
                                            new PermissionsBuilder()
                                                    .setDenied(PermissionType.CONNECT)
                                                    .build()
                                    )
                                    .update();
                            MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur : " + event.getMessage().getMentionedUsers().get(0).getName() + " à été ajouter à la black list", 10_000);
                        });


                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir un utilisateur à blacklist", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("name")) {

                    if (args.length >= 2) {

                        Optional<ServerVoiceChannel> channel = event.getMessageAuthor().getConnectedVoiceChannel();

                        channel.ifPresent(c -> {

                            int i = 0;

                            while (i <= (args.length - 1)) {
                                if (i == 0) {
                                    i++;
                                }
                                name = name + " " + args[i];
                                i++;
                            }

                            new ServerVoiceChannelBuilder(event.getServer().get())
                                    .setName("🔓" + name + " 🔓")
                                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.MOVE_MEMBERS, PermissionType.CREATE_INSTANT_INVITE, PermissionType.CONNECT).build())
                                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), c.getOverwrittenPermissions(event.getServer().get().getEveryoneRole()))
                                    .setCategory(event.getServer().get().getChannelCategoryById(config.channelcategory).get())
                                    .create().thenAcceptAsync(serverVoiceChannel -> {
                                int members = event.getMessageAuthor().getConnectedVoiceChannel().get().getConnectedUsers().size();
                                int a = 0;
                                do {
                                    event.getMessageAuthor().getConnectedVoiceChannel().get().getConnectedUsers().forEach(user -> {
                                        try {
                                            Thread.sleep(80);
                                            user.move(serverVoiceChannel);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    });
                                    a++;
                                } while (a == members + 1);
                                a = 0;
                                try {
                                    Thread.sleep(200);
                                    c.delete();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                MessageUtils.sendAndDelete(event.getChannel(), "Vous avez modifiez le nom du channel en :" + name, 10_000);
                                name = "";
                            });
                        });

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir un nouveau nom de channel", 10_000);

                    }

                }

                if (args[0].equalsIgnoreCase("op")) {

                    if (args.length >= 2) {

                        Optional<ServerVoiceChannel> channel = event.getMessageAuthor().getConnectedVoiceChannel();

                        channel.ifPresent(c -> {
                            channel.get().createUpdater()
                                    .addPermissionOverwrite(
                                            event.getMessage().getMentionedUsers().get(0),
                                            new PermissionsBuilder()
                                                    .setAllowed(PermissionType.MOVE_MEMBERS)
                                                    .build()
                                    )
                                    .update();
                            MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur : " + event.getMessage().getMentionedUsers().get(0).getName() + " à été ajouter à la list des modérateurs", 10_000);
                        });

                    } else {

                        MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir un utilisateur à mettre modo sur votre channel", 10_000);

                    }

                }

            } else {
                MessageUtils.sendAndDelete(event.getChannel(), "Vous n'êtes pas le propriétaire de ce channel ni un modérateur", 10_000);
            }

        } else {
            MessageUtils.sendAndDelete(event.getChannel(), "Vous n'êtes pas dans un channel vocal", 10_000);
        }


    }

    public void theDescription(Command command) {

        description = command.getDescription();

    }

}
