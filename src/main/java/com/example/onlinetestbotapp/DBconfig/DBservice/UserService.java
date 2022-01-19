package com.example.onlinetestbotapp.DBconfig.DBservice;

import com.example.onlinetestbotapp.DBconfig.entity.User;
import com.example.onlinetestbotapp.DBconfig.repository.UserRepository;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class UserService  {

    public void saveUser(Update update, String state, UserRepository userRepository) {
        String name = update.getMessage().getContact().getFirstName();
        String phoneNumber = update.getMessage().getContact().getPhoneNumber();
        Long chatId = update.getMessage().getChatId();

        User user = new User();
        user.setState(state);
        user.setChatId(chatId);
        user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    public void saveUserWithChatId(Update update, String state, UserRepository userRepository) {
        User user = new User();
        user.setState(state);
        user.setChatId(update.getMessage().getChatId());
        userRepository.save(user);
    }

    public void saveUserFullName(Update update, String state, UserRepository userRepository) {
        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());
        User user =optionalUser.get();
        user.setFullName(update.getMessage().getText());
        user.setState(state);
        user.setChatId(update.getMessage().getChatId());
        userRepository.save(user);
    }


    public void saveUserOfPhoneNumber(Update update, String  state, UserRepository userRepository) {
        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());
        User user = optionalUser.get();
        user.setPhoneNumber(update.getMessage().getText());
        user.setState(state);
        user.setChatId(update.getMessage().getChatId());
        userRepository.save(user);
    }

    public void saveUserWithContactPhoneNumber(Update update, String  state, UserRepository userRepository) {
        Optional<User> optionalUser = userRepository.findByChatId(update.getMessage().getChatId());
        String userName = update.getMessage().getFrom().getUserName();
        User user = optionalUser.get();
        user.setPhoneNumber(update.getMessage().getContact().getPhoneNumber());
        user.setState(state);
        user.setUserName(userName);
        user.setChatId(update.getMessage().getChatId());
        userRepository.save(user);
    }
}
