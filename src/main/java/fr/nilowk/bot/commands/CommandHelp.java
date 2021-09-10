package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandHelp implements CommandExecutor {

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {
        event.getMessage().delete();
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor(config.serverName, "", config.logoserver)
                .setTitle("**liste des commandes :**")
                .addField("**-help**", command.getDescription())
                .addField("**-rules**", CommandRules.description)
                .addField("**-new**", CommandNew.description)
                .addField("**-close**", CommandClose.description)
                .addField("**-play**", CommandPlay.description)
                .addField("**-cconfig**", CommandCconfig.description)
                .addField("***-clear***", CommandClear.description)
                .addField("***-warn***", CommandWarn.description)
                .addField("***-kick***", CommandKick.description)
                .addField("***-ban***", CommandBan.description)
                .addField("***-annonce message***", CommandAnnonce.description)
                .addField("***-config***", CommandConfig.description)
                .addField("***-st***", CommandSt.description)
                .setFooter("By Nilowk")
                .setTimestampToNow();
        event.getChannel().sendMessage(embed);
    }

    @Override
    public void theDescription(Command command) {

    }
}
