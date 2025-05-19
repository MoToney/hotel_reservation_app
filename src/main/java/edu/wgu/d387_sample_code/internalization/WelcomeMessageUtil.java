package edu.wgu.d387_sample_code.internalization;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class WelcomeMessageUtil {

    private final ExecutorService executorService;
    private final List<Locale> locales;

    public WelcomeMessageUtil(ExecutorService executorService, List<Locale> locales) {
        this.executorService = executorService;
        this.locales = locales;
    }

    // returns the welcome message located inside the locale that is passed as an argument
    private String getWelcomeMessage(Locale locale) {
        try {
        ResourceBundle bundle = ResourceBundle.getBundle("language", locale);
        return bundle.getString("welcome");
        } catch (Exception e) {
            return "Message unavailable in " + locale.getLanguage();
        }
    }

    // uses threads to gather the welcome messages and place them inside an array of strings
    public List<String> getWelcomeMessages() {
        List<Future<String>> futures = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        try {
            for (Locale locale : locales) {
                futures.add(executorService.submit(() -> getWelcomeMessage(locale)));
            }
            for (Future<String> future : futures) {
                messages.add(future.get());
            }
        } catch (Exception e) {
            System.out.println("welcome messages not found: " + e.getMessage());
        }
        return messages;
    }
}
