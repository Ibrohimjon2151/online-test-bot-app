package com.example.onlinetestbotapp;

import com.example.onlinetestbotapp.DBconfig.DBservice.UserService;
import com.example.onlinetestbotapp.DBconfig.entity.Admin;
import com.example.onlinetestbotapp.DBconfig.repository.AdminRepository;
import com.example.onlinetestbotapp.DBconfig.repository.UserRepository;
import com.example.onlinetestbotapp.bot.BotService.AdminServiceImpl;
import com.example.onlinetestbotapp.bot.BotService.SendServiceMessageImp;
import com.example.onlinetestbotapp.bot.constants.AdminState;
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

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminServiceImpl adminService;

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
                if (!exists) {
                    execute(sendServiceMessageImp.WelcomeToBot(update));
                    userService.saveUserWithChatId(update, BotState.START, userRepository);
                    return;
                } else {
                    userService.updateState(update, BotState.MENU, userRepository);
                    execute(sendServiceMessageImp.sendMenuPage(update));
                }
            }

            Long chatId = update.getMessage().getChatId();
            String state = userRepository.findByChatId(chatId).get().getState();
            /**
             *
             * USER UCHUN STATE BO'YICHA HABAR CHO'NATISH
             */
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


            /**
             *
             * ADMIN UCHUN STATE BO'YICHA HABAR CHO'NATISH
             */
            for (Admin admin : adminRepository.findAll()) {
                if (admin.getPassword().equals(update.getMessage().getText())) {
                    userService.updateStateAdmin(update, AdminState.ENTERADMIN, adminRepository);
                }
            }

            String stateAdmin = adminRepository.findByChatId(update.getMessage().getChatId()).get().getState();
            switch (stateAdmin) {
                case AdminState.ENTERADMIN:
                    execute(sendServiceMessageImp.deleteMessage(update));
                    userService.updateStateAdmin(update , AdminState.ADMINPANEL, adminRepository);
                    execute(adminService.sendAdminPanel(update));
                    break;
            }


            /**
             *
             * TEXT HABAR BO'YICHA HABAR CHO'NATISH
             */
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
