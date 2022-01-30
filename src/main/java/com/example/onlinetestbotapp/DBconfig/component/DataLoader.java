package com.example.onlinetestbotapp.DBconfig.component;

import com.example.onlinetestbotapp.DBconfig.entity.Admin;
import com.example.onlinetestbotapp.DBconfig.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AdminRepository adminRepository;

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

        }

    }

}
