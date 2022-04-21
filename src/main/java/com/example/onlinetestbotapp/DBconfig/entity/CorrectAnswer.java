package com.example.onlinetestbotapp.DBconfig.entity;

import com.example.onlinetestbotapp.DBconfig.entity.template.AbsEntityId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CorrectAnswer extends AbsEntityId {
    private String answer;

    @OneToOne
    private Question question;
}
