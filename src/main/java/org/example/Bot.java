package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot extends ListenerAdapter {
    public static void main(String[] args) {
        // 環境變數讀取 Discord Token
        String token = System.getenv("DISCORD_TOKEN");

        try {
            JDABuilder.createDefault(token,
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new Bot())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("🏓 Pong!").queue();
        }
    }
}
