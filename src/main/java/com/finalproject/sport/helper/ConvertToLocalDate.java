package com.finalproject.sport.helper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertToLocalDate {
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
