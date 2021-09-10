package fr.nilowk.bot.utils;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.commands.MessageManager;
import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberLeaveEvent;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.event.server.member.ServerMemberLeaveEvent;

public class UtilsManager {

    public static void joinVoc(ServerVoiceChannelMemberJoinEvent event) {

        if (event.getChannel() == event.getServer().getVoiceChannelById(MessageManager.config.channelcreater).get()) {

            new ServerVoiceChannelBuilder(event.getServer())
                    .setName("🔓 channel de " + event.getUser().getName() + " 🔓")
                    .setCategory(event.getServer().getChannelCategoryById(MessageManager.config.channelcategory).get())
                    .create().thenAcceptAsync(serverVoiceChannel -> {
                        event.getUser().move(serverVoiceChannel);
                    });



        }



    }

    public static void leaveVoc(ServerVoiceChannelMemberLeaveEvent event) {

        if (event.getChannel() != event.getServer().getVoiceChannelById(MessageManager.config.channelcreater).get()) {

            if (event.getChannel().getCategory().get() == event.getServer().getChannelCategoryById(MessageManager.config.channelcategory).get()) {

                if (event.getChannel().getConnectedUsers().size() == 0) {

                    event.getChannel().delete();

                }
            }

        }

    }

    public static void joinServer(ServerMemberJoinEvent event) {

        event.getServer().getTextChannelById(Config.welcomechannel).get().sendMessage("bienvenue à " + event.getUser().getMentionTag() + ", merci grâce à toi nous sommes : " + event.getServer().getMemberCount() + " membres");

    }

    public static void leaveServer(ServerMemberLeaveEvent event) {

        event.getServer().getTextChannelById(Config.welcomechannel).get().sendMessage(event.getUser().getMentionTag() + " à quitter le server nous espérons te revoir très prochainement");

    }

    public static void acceptRules(ReactionAddEvent event) {

        if (event.getEmoji().equalsEmoji("✅")) {

            event.getUser().get().addRole(event.getServer().get().getRoleById(Config.memberRole).get());

        }

    }
}
