package web;

import javax.inject.Named;
import java.util.Date;

@Named("dates")
public class DatesBean {
    public Date getCurrentDate() {
        return new Date();
    }
}
