package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyTelegramBotController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        List<List<InlineKeyboardButton>> rowList = getLists();

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(rowList);

        SendMessage sendMessage = new SendMessage();

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("hallo ");

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<List<InlineKeyboardButton>> getLists() {
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("button1");
        button1.setCallbackData("callback_data1");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("button2");
        button2.setCallbackData("callback_data2");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("button3");
        button3.setCallbackData("callback_data3");

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        row1.add(button2);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button3);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);

        return rowList;
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
