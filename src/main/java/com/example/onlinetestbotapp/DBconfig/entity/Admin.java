package com.example.onlinetestbotapp.DBconfig.entity;

import com.example.onlinetestbotapp.DBconfig.entity.template.AbsEntityId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends AbsEntityId {

    private String fullName;

    private String state;

    private String phoneNumber;

    @Column(unique = true)
    private Long chatId;

    private String password;
}
