package edu.wgu.d387_sample_code.internalization;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class WelcomeMessageController {

    private final WelcomeMessageUtil welcomeMessageUtil;

    public WelcomeMessageController(WelcomeMessageUtil welcomeMessageUtil) {
        this.welcomeMessageUtil = welcomeMessageUtil;
    }

    // displays array of welcome messages at localhost:8000/api/welcome
    @GetMapping("/welcome")
    public List<String> WelcomeMessages() {
        List<String> messages = welcomeMessageUtil.getWelcomeMessages();
        return messages;
    }
}
