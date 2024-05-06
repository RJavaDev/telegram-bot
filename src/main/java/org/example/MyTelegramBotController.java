package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBotController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String adminChatId = "1231810507";

        Message message = update.getMessage();
        User user = message.getFrom();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        Location location = message.getLocation();

        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(adminChatId);
        sendLocation.setLongitude(location.getLongitude());
        sendLocation.setLatitude(location.getLatitude());

        sendMessage.setText("Hallo " + user.getFirstName());
        System.out.println(update);
        try {
            execute(sendMessage);
            sendMessage.setText(String.format("Hallo admin %s Location", user.getFirstName()));
            sendMessage.setChatId(adminChatId);
            execute(sendMessage);
            execute(sendLocation);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "transaction9918bot";
    }

    @Override
    public String getBotToken() {
        return "5651368205:AAF292oK7yYHjuJfd3WHEdhwZ2FYe9bMTNA";
    }
}
