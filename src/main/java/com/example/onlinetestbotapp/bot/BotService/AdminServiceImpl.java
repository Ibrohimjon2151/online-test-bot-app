package com.example.onlinetestbotapp.bot.BotService;

import com.example.onlinetestbotapp.bot.ServiceInterface.AdminService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class AdminServiceImpl implements AdminService {

    @Override
    public SendMessage sendAdminPanel(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText("Assalomu alaykum admin paneliga hush kelibsiz quydagilardan birini tanlashingiz mumkin");

        SendServiceMessageImp.makeInlineKeyboardButton()
        return sendMessage;
    }
}
