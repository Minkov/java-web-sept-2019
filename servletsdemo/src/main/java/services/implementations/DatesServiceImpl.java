package services.implementations;

import services.DatesService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesServiceImpl implements DatesService {
    private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

    @Override
    public String getNowFormatted() {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        return formatter.format(date);
    }
}
