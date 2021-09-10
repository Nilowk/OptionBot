package fr.nilowk.bot;

import fr.nilowk.bot.commands.CommandNew;
import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.UtilsManager;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandRegistry;
import fr.nilowk.bot.utils.commands.MessageManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static DiscordApi api;
    public static Config config = new Config();
    public static Command command;
    private static CommandRegistry registry = MessageManager.registry;

    public static void main(String[] args) {

        System.out.println("bot ok");

        registry.getByAlias("cconfig").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("clear").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("kick").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("ban").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("annonce").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("config").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("close").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("rules").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("warn").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("play").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        registry.getByAlias("st").ifPresent((cmd -> {
            cmd.getExecutor().theDescription(cmd);
        }));
        CommandNew.theDescription();

        api = new DiscordApiBuilder()
                .setToken(config.token)
                .setAllIntents()
                .login()
                .join();

        api.addMessageCreateListener(MessageManager::create);
        api.addServerVoiceChannelMemberJoinListener(UtilsManager::joinVoc);
        api.addServerVoiceChannelMemberLeaveListener(UtilsManager::leaveVoc);
        api.addServerMemberJoinListener(UtilsManager::joinServer);
        api.addServerMemberLeaveListener(UtilsManager::leaveServer);
        api.addReactionAddListener(UtilsManager::acceptRules);

        

    }

}
