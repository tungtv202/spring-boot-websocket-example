package springboot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @Autowired
    SimpMessagingTemplate template;

    @RequestMapping("/test")
    public void sendAdhocMessages(@RequestParam("payload") String payload) {
        template.convertAndSend("/topic/001", payload);
    }

    @MessageMapping("/rm002")
    @SendTo("/topic/001")
    public String getUser(String payload) {
        return ("From rm002 " + payload);
    }
}
