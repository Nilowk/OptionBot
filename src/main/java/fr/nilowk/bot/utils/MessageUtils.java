package fr.nilowk.bot.utils;

import org.javacord.api.entity.channel.TextChannel;

import java.util.concurrent.CompletableFuture;

public class MessageUtils {

    public static CompletableFuture<Void> sendAndDelete(TextChannel channel, String message, long delay) {

        CompletableFuture<Void> future = new CompletableFuture<>();
        channel.sendMessage(message)
                .thenAcceptAsync(msg -> {
                    try {
                        Thread.sleep(delay);
                        msg.delete().thenAcceptAsync(future::complete);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        return future;

    }

}
