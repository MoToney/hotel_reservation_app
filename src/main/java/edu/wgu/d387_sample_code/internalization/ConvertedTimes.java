package edu.wgu.d387_sample_code.internalization;

import org.springframework.stereotype.Component;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ConvertedTimes {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");


    public List<String> getTimes() {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("America/New_York"));

        String est = time.withZoneSameInstant(ZoneId.of("America/New_York")).format(formatter);
        String mst = time.withZoneSameInstant(ZoneId.of("America/Phoenix")).format(formatter);
        String uct = time.withZoneSameInstant(ZoneId.of("UCT")).format(formatter);

        return List.of(uct, est, mst);
        }
    }