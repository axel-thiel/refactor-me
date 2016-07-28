import org.junit.Test;

import java.time.DayOfWeek;

import static org.junit.Assert.assertTrue;

/**
 * @author Hugh Glykod
 */
public class RestaurantTest {

    @Test
    public void testDefaultOpeningHours() {

        Restaurant myRestaurant = new Restaurant("toto");
        myRestaurant.getTablHoraire().get(DayOfWeek.FRIDAY).setTimeClose("17:00");
        System.out.println(myRestaurant.getTablHoraire().get(DayOfWeek.FRIDAY).getTimeClose());


       boolean isOpen = myRestaurant.isOpen(DayOfWeek.FRIDAY);

       assertTrue(isOpen);
    }
}
