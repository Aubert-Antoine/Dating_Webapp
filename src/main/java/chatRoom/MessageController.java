package chatRoom;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    private MessageRepository repository;
    final private String token = "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";

    CompletionRequest request = new CompletionRequest();
    String model = "text-davinci-002";
    OpenAiService service = new OpenAiService(token);
    CompletionResult response;

    @GetMapping("/MessageList")
    public Iterable<Message> getMessages() {
        // change return null to something more appropriate
        return repository.findAll();
    }

    @GetMapping("/addMessageandResponse")
    public RedirectView addMessageandResponse(@RequestParam final String message) {
      /*
      1. You need to create a message object and save it into the repository
      2. Make an api request to OpenAI with the message’s text and receive the answer.
      3. Create a new message object with the AI response and save it to the  repository.

        Remember, that you need to set the type  of the message as “Question”
        for the message of the user and “Answer”

       */

        Message messInput = new Message();

        // set the date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        messInput.setMessageDate(dtf.format(now));
        messInput.setMessageText(message);
        messInput.setMessageType("Question");

        repository.save(messInput);

        /*
        request to openAI :
         */
        request.setMaxTokens(250);
        request.setModel(model);
        request.setPrompt(message);
        response = service.createCompletion(request);
        List<CompletionChoice> responses = response.getChoices();


        /*
        Make a mess for the response
         */
        Message messOutput = new Message();
        messOutput.setMessageType("Answer");
        messOutput.setMessageDate(new Date().toString());
        StringBuilder out = new StringBuilder();
        for (CompletionChoice c : responses) {
            out.append(c.getText());
        }

        messOutput.setMessageText(out.toString());

        // if(debug) System.out.println(String.format("The message output of openAi is %s",messOutput.getMessageText()));

        repository.save(messOutput);

        return new RedirectView("main.html");


    }

    @GetMapping("/deleteMessage")
    public RedirectView deleteMessage(@RequestParam Integer id) {
        // add code to delete message
        for (Message message : getMessages()) {

            if (message.getId() == id) {
                repository.delete(message);
            }
        }//for
        return new RedirectView("main.html");

    }

    @GetMapping("/")
    public RedirectView executeOnce() {
        return new RedirectView("login.html");

    }
}