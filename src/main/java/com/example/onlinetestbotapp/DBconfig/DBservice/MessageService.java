package com.example.onlinetestbotapp.DBconfig.DBservice;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;


@Service
public class MessageService {

    public void saveNewMessage(String mainmenu, Update update, MessagesRepository messagesRepository) {

        for (Messages messages1 : messagesRepository.findAll()) {
            messages1.setStatus(false);
            messagesRepository.save(messages1);
        }
        Messages messages = new Messages();
        messages.setTitle(mainmenu);
        messages.setText(update.getMessage().getText());
        messages.setStatus(true);
        messagesRepository.save(messages);
    }
}
