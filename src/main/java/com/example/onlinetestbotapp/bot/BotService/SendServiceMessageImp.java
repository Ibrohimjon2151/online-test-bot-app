package com.example.onlinetestbotapp.bot.BotService;

import com.example.onlinetestbotapp.bot.ServiceInterface.SendServiceMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SendServiceMessageImp implements SendServiceMessage {

    /**
     * BOTGA KIRGANDA ISHLAYDI
     * @param update
     * @return
     */
    @Override
    public SendMessage WelcomeToBot(Update update) {
        StringBuilder stringBuilder = new StringBuilder();
        Long chatId = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.enableHtml(true);

        stringBuilder.append("Assalomu alaykum hurmatli " + "<b>" + update.getMessage().getFrom().getFirstName() + "</b>" + "" +
                " Online Testlar botimizga xush kelibsiz \uD83E\uDD17.");

        stringBuilder.append("Keling siz bilan tanishib olamiz, to'liq ism familyangizni kiriting.\n" +
                "Misol uchun <i>Sardor Abdumalikov</i>");
        sendMessage.setText(String.valueOf(stringBuilder));

        return sendMessage;

    }


    /**
     * USERDAN TELFON RAQAMINI OLISH UCHUN SO'ROV
     * @param update
     * @return
     */
    @Override
    public SendMessage sendGetPhoneNumberPage(Update update) {
        StringBuilder stringBuilder = new StringBuilder();
        Long chatId = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.enableHtml(true);

        stringBuilder.append("Telegram telfon raqamini jo'nating \uD83D\uDC47 yoki ");

        stringBuilder.append("o'zingiz kiriting misol uchun \uD83D\uDC49 <i>+998909876543</i>");
        sendMessage.setText(String.valueOf(stringBuilder));


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();


        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);


        List<KeyboardRow> keyboard = new ArrayList<>();


        KeyboardRow keyboardFirstRow = new KeyboardRow();

        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setRequestContact(true);
        keyboardButton.setText("Kontakt jo'natish \uD83D\uDCDE");
        keyboardFirstRow.add(keyboardButton);

        keyboard.add(keyboardFirstRow);

        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    /**
     * MENU PAGENI JO'NATISH
     * @param update
     * @return
     */
    @Override
    public SendMessage sendMenuPage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        String userName = update.getMessage().getFrom().getUserName();
        sendMessage.setText("Hali nima yozishni bilmadim \uD83E\uDD37\u200D♂️\n@"+userName);
        return sendMessage;
    }

    /**
     * INLINE BUTTON YASASH
     * @param array
     * @return
     */
    public static InlineKeyboardMarkup makeInlineKeyboardButton(String[] array) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {

                row = getInlineKeyboardButtons(array, row, rowlist, i);
            } else if (array.length - 1 == i) {
                row = getInlineKeyboardButtons(array, row, rowlist, i);
            } else {
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

                inlineKeyboardButton.setText(array[i]);
                inlineKeyboardButton.setCallbackData(array[i]);

                row.add(inlineKeyboardButton);
            }
        }
        inlineKeyboardMarkup.setKeyboard(rowlist);
        return inlineKeyboardMarkup;
    }
    private static List<InlineKeyboardButton> getInlineKeyboardButtons(String[] array, List<InlineKeyboardButton> row, List<List<InlineKeyboardButton>> rowlist, int i) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

        inlineKeyboardButton.setText(array[i]);
        inlineKeyboardButton.setCallbackData(array[i]);

        row.add(inlineKeyboardButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();

        rowlist.add(row);
        row = row2;
        return row;
    }

}

