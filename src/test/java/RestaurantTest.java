import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Hugh Glykod
 */
public class RestaurantTest {


    //test for sunday (closed day) at real system time.

    @Test
    public void testSundayActualTime() {

        Restaurant myRestaurant = new Restaurant("toto");
        boolean isOpen = myRestaurant.isOpen(DayOfWeek.SUNDAY);

       assertFalse(isOpen);
    }

    // test for a classical open day (ex:Thursday) with real system time

    @Test
    public void testMondayActualTime() {

        Restaurant myRestaurant = new Restaurant("toto");
        boolean isOpen = myRestaurant.isOpen(DayOfWeek.THURSDAY);

        assertTrue(isOpen);
    }




}
