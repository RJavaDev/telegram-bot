package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MainTelegramBot {

    public static void main(String[] args) throws TelegramApiException {

        MyTelegramBotController myTelegramBotController = new MyTelegramBotController();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        telegramBotsApi.registerBot(myTelegramBotController);
    }
}
