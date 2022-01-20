package com.example.onlinetestbotapp.bot.ServiceInterface;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface AdminService {

    SendMessage sendAdminPanel(Update update);







    String ADDNEWMESSAGE = "Yangi habar qo'shish\uD83D\uDCDD";

    String VIEWUSERSINFORMATION = "Userlar malumotlarini ko'rish\uD83E\uDDD3";

    String VIEWCURRENTMESSAGES = "Xozirda mavjud habarlarini ko'rish\uD83D\uDCC4";

    String ADDNEWADMIN = "Yangi";

}
