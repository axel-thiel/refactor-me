import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hugh Glykod
 */

public class Restaurant {

    private String name;

    private Clock clock = Clock.systemDefaultZone();

    private Map<DayOfWeek,Horaires> tablHoraire;



    public Restaurant(String name) {
        this.name = name;
        tablHoraire = new HashMap<>();
        initTablHoriare();
    }

    private void initTablHoriare() {
        tablHoraire.put(DayOfWeek.MONDAY, new Horaires());
        tablHoraire.put(DayOfWeek.TUESDAY, new Horaires());
        tablHoraire.put(DayOfWeek.WEDNESDAY, new Horaires());
        tablHoraire.put(DayOfWeek.THURSDAY, new Horaires());
        tablHoraire.put(DayOfWeek.FRIDAY, new Horaires());
        tablHoraire.put(DayOfWeek.SATURDAY, new Horaires());
    }

    public boolean isOpen() {

        DayOfWeek day = LocalDate.now(clock).getDayOfWeek();
    if (tablHoraire.containsKey(day)){
         if (LocalTime.now(clock).isAfter(LocalTime.parse(this.tablHoraire.get(day).getTimeOpen()))
                 && LocalTime.now(clock).isBefore(LocalTime.parse(this.tablHoraire.get(day).getTimeClose()))) {

             return true;
         } else {
             return false;
         }
     } return false;

 }


    public Map<DayOfWeek, Horaires> getTablHoraire() {
        return tablHoraire;
    }

    public void setTablHoraire(Map<DayOfWeek, Horaires> tablHoraire) {
        this.tablHoraire = tablHoraire;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
