package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.Config;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandRules implements CommandExecutor {

    public static String description = "";

    @Override
    public void run(MessageCreateEvent event, Config config, Command command, String[] args) {

        event.getMessage().delete();
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("Skylize RP", "", "https://i.postimg.cc/g2QYSZr3/logo.png")
                .setTitle("**Règlement :**")
                .addField(
                        "**:smiley: 1.Comportement**",
                        "Soyez courtois et civilisé."
                )
                .addField(
                        "**:abc: 2.Orthographe**",
                        "Une écriture française correcte est exigée."
                )
                .addField(
                        "**:anger_right: 3.Contenu des messages**",
                        "Aucun contenu raciste, sexiste ou autre offense ne sera toléré."
                )
                .addField(
                        "**:incoming_envelope: 4.Message**",
                        "Le spam / flood est interdit."
                )
                .addField(
                        "**:no_bell: 5.Message privé**",
                        "Veuillez ne pas mentionner ou envoyer un message directement aux membres du staff. Les ticket sont là pour ça. En cas d'achat vous avez l'autotrisation de contacter Nilowk par message privé"
                )
                .addField(
                        "**:card_index: 6.Pseudo**",
                        "utilisez un nom et un avatar appropriés."
                )
                .addField(
                        "**:loudspeaker: 7.Pub**",
                        "ne faites pas de pub pour un autre serveur (Discord / FiveM) sauf si vous avez une autorisation"
                )
                .addField(
                        "**:head_bandage: 8.Harcèlement**",
                        "Aucun harcèlement, abus ou intimidation ne sera toléré."
                )
                .addField(
                        "**:classical_building: 9.Sujets interdit**",
                        "Afin de garantir une bonne entante entre chaque personne evitez les sujets politiques ou religieux"
                )
                .addField(
                        "**:mute: 10.Comportement en vocal**",
                        "Dans un environement bruyant, respectez tout le monde en utilisant le push to talk au besoin."
                )
                .addField(
                        "**:thinking: 11.Bon sens**",
                        "Les règles ne sont pas exhaustives. Veuillez faire preuve de bon sens."
                )
                .setFooter("By Nilowk")
                .setTimestampToNow();
        event.getChannel().sendMessage("@everyone", embed);

    }

    @Override
    public void theDescription(Command command) {

        description = command.getDescription();

    }
}
