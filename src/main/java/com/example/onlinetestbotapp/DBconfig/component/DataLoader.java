package com.example.onlinetestbotapp.DBconfig.component;

import com.example.onlinetestbotapp.DBconfig.entity.Admin;
import com.example.onlinetestbotapp.DBconfig.entity.Messages;
import com.example.onlinetestbotapp.DBconfig.repository.AdminRepository;
import com.example.onlinetestbotapp.DBconfig.repository.MessagesRepository;
import com.example.onlinetestbotapp.bot.constants.MessageConstanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    MessagesRepository messagesRepository;

    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {
            adminRepository.save(new Admin(
                    "Ibrohimjon Yursunov",
                    "admin",
                    "+998911082151",
                    1236905987L,
                    "123"
            ));
            messagesRepository.save(new Messages(
                    MessageConstanta.MAINMENU,
                    "Assalomu alaykum Hush kelibsiz",
                    true,
                    false
            ));

        }

    }

}
