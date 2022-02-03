package com.example.onlinetestbotapp.bot.ServiceInterface;

import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface AdminService {

    SendMessage sendAdminPanel(Update update);

    SendMessage sendMessageStatus(Update update);

    List<SendMessage> changeMenuMessage(Update update, MessagesRepository messagesRepository);

    SendMessage sendCommandNewMessage(Update update);
}
