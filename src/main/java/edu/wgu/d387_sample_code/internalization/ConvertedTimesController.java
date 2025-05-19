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

    @GetMapping("/times")
    public List<String> displayTimezones() {
        ConvertedTimes convertedTimes = new ConvertedTimes();
        return convertedTimes.getTimes();
    }
}
