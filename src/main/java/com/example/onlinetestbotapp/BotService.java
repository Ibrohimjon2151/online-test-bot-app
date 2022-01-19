package com.example.onlinetestbotapp;

import com.example.onlinetestbotapp.DBconfig.DBservice.UserService;
import com.example.onlinetestbotapp.DBconfig.repository.UserRepository;
import com.example.onlinetestbotapp.bot.BotService.SendServiceMessageImp;
import com.example.onlinetestbotapp.bot.constants.BotState;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class BotService extends TelegramLongPollingBot {
    @Value("${bot.token}")
    String token;
    @Value("${bot.username}")
    String username;

    static SendServiceMessageImp sendServiceMessageImp = new SendServiceMessageImp();
    static UserService userService = new UserService();
    @Autowired
    UserRepository userRepository;


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasCallbackQuery()) {

        } else if (update.getMessage().hasContact()) {
            userService.saveUserWithContactPhoneNumber(update, BotState.MENU, userRepository);
            execute(sendServiceMessageImp.sendMenuPage(update));

        } else if (update.hasMessage()) {

            if (update.getMessage().getText().equals("/start")) {
                boolean exists = userRepository.existsByChatId(update.getMessage().getChatId());
                if (exists) {
                    execute(sendServiceMessageImp.WelcomeToBot(update));
                    userService.saveUserWithChatId(update, BotState.START, userRepository);
                    return;
                }
                userService.saveUserOfPhoneNumber(update, BotState.MENU, userRepository);
                execute(sendServiceMessageImp.sendMenuPage(update));
            }

            Long chatId = update.getMessage().getChatId();
            String state = userRepository.findByChatId(chatId).get().getState();
            switch (state) {
                case BotState.START:
                    userService.saveUserFullName(update, BotState.GETPHONENUMBER, userRepository);
                    execute(sendServiceMessageImp.sendGetPhoneNumberPage(update));
                    break;
                case BotState.GETPHONENUMBER:
                    userService.saveUserOfPhoneNumber(update, BotState.MENU, userRepository);
                    execute(sendServiceMessageImp.sendMenuPage(update));
                    break;
            }


            String message = update.getMessage().getText();
            switch (message) {
                case "start":

                    break;
            }

        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}