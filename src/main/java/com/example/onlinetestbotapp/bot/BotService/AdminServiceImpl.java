package com.example.onlinetestbotapp.bot.BotService;

import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import com.example.onlinetestbotapp.bot.ServiceInterface.AdminService;
import com.example.onlinetestbotapp.bot.constants.AdminConstanta;
import com.example.onlinetestbotapp.bot.constants.MenuConstants;
import com.example.onlinetestbotapp.bot.constants.MessageConstanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    SendServiceMessageImp sendServiceMessageImp;


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

    @Override
    public SendMessage sendMessageStatus(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.hasCallbackQuery()) {
            sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        } else {
            sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        }
        sendMessage.setText("Qaysi statusga habar qo'shmoqchisiz");
        String[] list = {AdminConstanta.STATUSMENU, MenuConstants.BACK};
        InlineKeyboardMarkup inlineKeyboardMarkup = SendServiceMessageImp.makeInlineKeyboardButtonOnerow(list);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public List<SendMessage> changeMenuMessage(Update update, MessagesRepository messagesRepository) {
        List<SendMessage> sendMessageList = new ArrayList<>();
        List<Messages> allByTitle = messagesRepository.findAllByTitle(MessageConstanta.MAINMENU);

        for (Messages messages : allByTitle) {
            SendMessage sendMessage = new SendMessage();
            if (update.hasCallbackQuery()) {
                sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
            }
            sendMessage.setText(messages.getText());
            String list [] = {MessageConstanta.DOACTIVE , MessageConstanta.DELETEMESSAGE};
            InlineKeyboardMarkup inlineKeyboardMarkup = SendServiceMessageImp.makeInlineKeyboardButton(list);
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
            sendMessageList.add(sendMessage);
        }

        return sendMessageList;
    }

    @Override
    public SendMessage sendCommandNewMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getCallbackQuery().getMessage().getChatId()));
        sendMessage.setText("Yangi habarni jo'nating\uD83D\uDC47\uD83D\uDC47");
        return sendMessage;
    }
}
