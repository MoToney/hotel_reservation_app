package edu.wgu.d387_sample_code.internalization;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ConvertedTimesController {

    private final ConvertedTimes convertedTimes;

    public ConvertedTimesController(ConvertedTimes convertedTimes) {
        this.convertedTimes = convertedTimes;
    }

    // displays array of times at localhost:8000/api/times
    @GetMapping("/times")
    public List<String> displayTimes() {
        return convertedTimes.getTimes();
    }
}
