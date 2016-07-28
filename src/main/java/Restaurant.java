import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hugh Glykod
 */

public class Restaurant {

    private String name;
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
    }


 public boolean isOpen(DayOfWeek day) {
          if (LocalTime.now().isAfter(LocalTime.parse(this.tablHoraire.get(day).getTimeOpen()))
                  && LocalTime.now().isBefore(LocalTime.parse(this.tablHoraire.get(day).getTimeClose()))) {
                return true;
            } else {
                return false;
            }
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<DayOfWeek, Horaires> getTablHoraire() {
        return tablHoraire;
    }

    public void setTablHoraire(Map<DayOfWeek, Horaires> tablHoraire) {
        this.tablHoraire = tablHoraire;
    }
}
