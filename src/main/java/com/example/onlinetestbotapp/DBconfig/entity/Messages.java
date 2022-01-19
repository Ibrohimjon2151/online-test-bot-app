package com.example.onlinetestbotapp.DBconfig.entity;

import com.example.onlinetestbotapp.DBconfig.entity.template.AbsEntityId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Messages extends AbsEntityId {
    private String title;

    private String description;
}
