
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends ListenerAdapter
{
    private static int daysSober;
    private static String quote;
    private static int oldNumber;

    public static void main(String [] args) throws LoginException, IOException
    {
        int index = 0;
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "insert token here";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();

        File quotesFile = new File("C:\\Users\\fluff\\Desktop\\quotes.txt");
        Scanner fileInput = new Scanner(quotesFile);

        ArrayList<String> quotesList = new ArrayList<String>();

        while (fileInput.hasNextLine())
        {
            quotesList.add(fileInput.nextLine());
        }

        daysSober = 46;
        oldNumber = daysSober;







        double t0 = System.currentTimeMillis(), t1;

        while(true)
        {
            if((t1 = System.currentTimeMillis()) - t0 >= 1000 * 60 * 60 * 24)
            {
                daysSober++;
                t0 = t1;
            }

            /*if (daysSober >= oldNumber)
            {
                quote = (quotesList.get(index));
                index++;
            }*/

        }


    }

    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.println("We have received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());



        if (event.getMessage().getContentRaw().equals("!clean"))
        {
            event.getChannel().sendMessage("It has been " + daysSober + " days clean").queue();
        }

        if(event.getMessage().getContentRaw().equals("!reset"))
        {
            daysSober = 0;
            event.getChannel().sendMessage("Recovery is hard. Regret is harder.\n Brittany Burgunder").queue();
        }



    }


}
