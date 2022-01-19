package com.example.onlinetestbotapp.bot.ServiceInterface;

import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface SendServiceMessage {
    SendMessage WelcomeToBot (Update update);

    SendMessage sendGetPhoneNumberPage(Update update);

    SendMessage sendMenuPage(Update update);
}
