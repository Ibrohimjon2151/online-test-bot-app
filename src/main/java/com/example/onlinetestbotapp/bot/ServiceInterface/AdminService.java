package com.example.onlinetestbotapp.bot.ServiceInterface;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface AdminService {

    SendMessage sendAdminPanel(Update update);

    SendMessage sendMessageStatus(Update update);

    SendMessage changeMenuMessage(Update update, MessagesRepository messagesRepository);

    SendMessage sendCommandNewMessage(Update update);

    SendMessage sendViewMessages(Update update, Messages text);
}
