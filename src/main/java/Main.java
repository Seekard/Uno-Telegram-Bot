import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import telegram.bot.Bot;

import java.util.HashMap;
import java.io.*;

public class Main
{
    public static HashMap<String, String> getBotAttributes(String filepath){
        HashMap<String, String> attrs = new HashMap<>();

        try(FileReader reader = new FileReader(filepath))
        {
            BufferedReader bufReader = new BufferedReader(reader);
            attrs.put("botName", bufReader.readLine());
            attrs.put("botToken", bufReader.readLine());
        }
        catch(IOException ex){
            ex.printStackTrace(System.out);
        }
        return attrs;
    }
    public static void main(String[] args)
    {
        try {
            HashMap<String, String> botAttrs = getBotAttributes("../settings.txt");
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot( new Bot(
                    botAttrs.get("botName"),
                    botAttrs.get("botToken")
            ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
