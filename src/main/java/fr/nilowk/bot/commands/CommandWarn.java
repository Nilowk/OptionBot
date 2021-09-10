package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CommandWarn implements CommandExecutor {

    public static String description = "";
    private static ServerTextChannel channel;

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        if (event.getMessageAuthor().canKickUsersFromServer()) {
            if (args.length >= 2) {

                if (event.getServer().get().getTextChannels().stream().anyMatch(c -> c.getName().startsWith("📌warn-") && c.getTopic().startsWith("" + event.getMessage().getMentionedUsers().get(0).getId()))) {

                    event.getServer().get().getTextChannels().forEach(c -> {
                        if (c.getName().startsWith("📌warn-") && c.getTopic().startsWith("" + event.getMessage().getMentionedUsers().get(0).getId())) {

                            channel = c.getServer().getTextChannelById(c.getId()).get();

                        }
                    });
                    args = channel.getTopic().split(" ");
                    int number = Integer.parseInt(args[1]);
                    channel.updateTopic(args[0] + " " + (number + 1));
                    if (args[1].equalsIgnoreCase("4")) {
                        event.getServer().get().kickUser(event.getMessage().getMentionedUsers().get(0));
                    }
                    if (args[1].equalsIgnoreCase("6")) {
                        event.getServer().get().kickUser(event.getMessage().getMentionedUsers().get(0));
                    }
                    if (args[1].equalsIgnoreCase("8")) {
                        event.getServer().get().banUser(event.getMessage().getMentionedUsers().get(0));
                    }
                    args = event.getMessageContent().split(" ");
                    String message = "";
                    int i = 0;
                    while (i < args.length) {
                        if (i == 0) {
                            i = i + 2;
                        }
                        message = message + " " + args[i];
                        i++;
                    }
                    channel.sendMessage(event.getMessage().getMentionedUsers().get(0).getMentionTag() + " Vous avez été warn || raison : \n" + message);
                    channel = null;
                    message = "";


                } else {

                    new ServerTextChannelBuilder(event.getServer().get())
                            .setName("📌warn-" + event.getMessage().getMentionedUsers().get(0).getName() + "📌")
                            .setCategory(event.getServer().get().getChannelCategoryById(config.warncategory).get())
                            .addPermissionOverwrite(event.getMessage().getMentionedUsers().get(0), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                            .addPermissionOverwrite(event.getMessage().getMentionedUsers().get(0), new PermissionsBuilder().setDenied(PermissionType.SEND_MESSAGES).build())
                            .setTopic(event.getMessage().getMentionedUsers().get(0).getId() + " 1")
                            .create().thenAcceptAsync(channel -> {
                        String message = "";
                        int i = 0;
                        String[] arg = event.getMessageContent().split(" ");
                        while (i < arg.length) {
                            if (i == 0) {
                                i = i + 2;
                            }
                            message = message + " " + arg[i];
                            i++;
                        }
                        channel.sendMessage(event.getMessage().getMentionedUsers().get(0).getMentionTag() + " Vous avez été warn || raison : \n" + message);
                        channel = null;
                        message = "";
                    });

                }

            } else {

                MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir l'utilisateur à warn ainsi que la raison", 10_000);

            }

        } else {

            MessageUtils.sendAndDelete(event.getChannel(), "Vous n'avez pas la permission d'utiliser cette commande", 10_000);

        }

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }
}
