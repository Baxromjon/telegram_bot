package io.fl.waterbot.bot;

import io.fl.waterbot.entity.BotUser;
import io.fl.waterbot.repository.BotUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * created by Baxromjon
 * 09.06.2022
 **/

@Service
public class TgService {

    @Autowired
    BotUserRepository botUserRepository;

    @Autowired
    WaterBot waterBot;

    public void authService(Update update) {
        try {
            sendContactButton(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendContactButton(Update update) {
        try {
            Optional<BotUser> optionalTelegramState = botUserRepository.findByChatId(update.getMessage().getChatId());
            if (optionalTelegramState.isPresent()) {
                BotUser telegramState = optionalTelegramState.get();
//                if (telegramState.isPasswordTrue()) {
//                    getMenu(update);
//                } else {
//                    getContact(update);
//                }
            } else {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setText("Assalomu alaykum " + update.getMessage().getFrom().getFirstName() + "!\n" +
                        "Kirish uchun 'share contact' tugmasini bosing!");

                List<KeyboardRow> keyboardRows = new ArrayList<>();
                KeyboardRow keyboardRow = new KeyboardRow();
                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("Share contact").setRequestContact(true);

                Buttons(sendMessage, keyboardRows, keyboardRow, keyboardButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Buttons(SendMessage sendMessage, List<KeyboardRow> keyboardRows, KeyboardRow keyboardRow, KeyboardButton keyboardButton) throws org.telegram.telegrambots.meta.exceptions.TelegramApiException {
        keyboardRow.add(keyboardButton);
        keyboardRows.add(keyboardRow);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        waterBot.execute(sendMessage);
    }

}
