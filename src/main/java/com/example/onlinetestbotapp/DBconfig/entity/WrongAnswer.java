package com.example.onlinetestbotapp.DBconfig.entity;

import com.example.onlinetestbotapp.DBconfig.entity.template.AbsEntityId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WrongAnswer extends AbsEntityId {
    private String wrongAnswer;

    @ManyToOne
    private Question question;
}
