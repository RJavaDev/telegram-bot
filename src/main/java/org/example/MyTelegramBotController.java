package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.telegram.telegrambots.meta.api.methods.ActionType.TYPING;

public class MyTelegramBotController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        User user = message.getFrom();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        SendChatAction action = new SendChatAction();
        action.setChatId(String.valueOf(message.getChatId()));
        action.setAction(TYPING);

        sendMessage.setText("Hallo " + user.getFirstName());

        try {
            execute(action);

            Thread.sleep(3000);

            execute(sendMessage);

        } catch (TelegramApiException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(update);
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
