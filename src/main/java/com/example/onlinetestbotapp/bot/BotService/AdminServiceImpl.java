package com.example.onlinetestbotapp.bot.BotService;

import com.example.onlinetestbotapp.bot.ServiceInterface.AdminService;
import com.example.onlinetestbotapp.bot.constants.AdminConstanta;
import com.example.onlinetestbotapp.bot.constants.AdminState;
import com.example.onlinetestbotapp.bot.constants.MenuConstants;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public SendMessage sendAdminPanel(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.hasCallbackQuery()) {
            sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        } else {
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        }
        sendMessage.setText("Assalomu alaykum admin paneliga hush kelibsiz quydagilardan birini tanlashingiz mumkin\uD83D\uDC47");
        String[] listMenu = {AdminConstanta.ADDNEWMESSAGE, AdminConstanta.VIEWCURRENTMESSAGES, AdminConstanta.ADDNEWADMIN, AdminConstanta.VIEWUSERSINFORMATION, MenuConstants.BACK};
        InlineKeyboardMarkup inlineKeyboardMarkup = SendServiceMessageImp.makeInlineKeyboardButtonOnerow(listMenu);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
}
