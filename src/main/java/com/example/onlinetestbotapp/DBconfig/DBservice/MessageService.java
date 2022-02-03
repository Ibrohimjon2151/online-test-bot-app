package com.example.onlinetestbotapp.DBconfig.DBservice;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Service
public class MessageService {

    public void saveNewMessage(String mainmenu, Update update, MessagesRepository messagesRepository) {
        Optional<Messages> optionalMessages = messagesRepository.findByTitle(mainmenu);
        if (optionalMessages.isPresent()) {
            for (Messages messages1 : messagesRepository.findAll()) {
                messages1.setStatus(false);
                messagesRepository.save(messages1);
            }
            Messages messages = new Messages();
            messages.setTitle(mainmenu);
            messages.setText(update.getMessage().getText());
            messages.setStatus(true);
            messagesRepository.save(messages);

        } else {
            Messages messages = new Messages();
            messages.setTitle(mainmenu);
            messages.setText(update.getMessage().getText());
            messages.setStatus(true);
            messagesRepository.save(messages);
        }
    }
}
