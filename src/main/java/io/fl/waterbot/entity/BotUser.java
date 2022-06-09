package io.fl.waterbot.entity;

import io.fl.waterbot.entity.enums.LangEnum;
import io.fl.waterbot.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * created by Baxromjon
 * 09.06.2022
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BotUser extends AbsEntity {
    @Column(unique = true, nullable = false)
    private Long chatId;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LangEnum lang;

    private String state;
}
