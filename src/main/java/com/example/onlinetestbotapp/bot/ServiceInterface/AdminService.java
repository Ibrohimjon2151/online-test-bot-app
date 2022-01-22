package com.example.onlinetestbotapp.bot.ServiceInterface;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface AdminService {

    SendMessage sendAdminPanel(Update update);

}
