package io.fl.waterbot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * created by Baxromjon
 * 09.06.2022
 **/

@Component
public class WaterBot extends TelegramLongPollingBot {
    @Autowired
    TgService tgService;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            String text="Hello";
            SendMessage sendMessage=new SendMessage();
            if (update.getMessage().hasText()){
                if (update.getMessage().getText().equals("/start")){
//                    sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
//                    sendMessage.setText("Salom");

//                    try {
                        tgService.authService(update);
//                    } catch (TelegramApiException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@botwd_bot";
    }

    @Override
    public String getBotToken() {
        return "5544744231:AAGb2sPYuxkeRYCXBo11nzoLYPlc7JO62CE";
    }
}
