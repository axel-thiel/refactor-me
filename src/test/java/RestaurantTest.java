import org.junit.Test;

import java.time.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Hugh Glykod
 */
public class RestaurantTest {

    //test that the tablHoriaire is not empty
    @Test
    public void testTablHoraire(){
        Restaurant myRestaurant = new Restaurant("toto");
        assertThat(myRestaurant.getTablHoraire().isEmpty(), is(false));
    }

    //test that the clock method
    @Test
    public void testClockdata(){
        Restaurant myRestaurant = new Restaurant("toto");
        Clock testClock = Clock.systemDefaultZone();
        assertTrue(testclock(myRestaurant, testClock));
    }

    private boolean testclock(Restaurant myRestaurant, Clock testC) {
        if(myRestaurant.getClock().equals(testC)){return true;}
        else return false;
    }

    //test for Monday (open day) at open hour.
    @Test
    public void testMondayOpenTime() {
        String testingDate = "2016-07-04T10:00:00Z";
        boolean isOpen = false;
        assertTrue(isOpenTest(testingDate));
    }

    //test for Monday (open day) at closed hour.
    @Test
    public void testMondayClosedTime() {
        String testingDate = "2016-07-04T22:00:00Z";
        boolean isOpen = false;
        assertFalse(isOpenTest(testingDate));
    }

    //test for Sunday (open day) at open hour.
    @Test
    public void testSundayOpenHour() {
        String testingDate = "2016-07-03T10:00:00Z";
        boolean isOpen = false;
        assertFalse(isOpenTest(testingDate));
    }

    public boolean isOpenTest(String stD){
        Clock fakeCloke = Clock.fixed(Instant.parse(stD), ZoneId.systemDefault());
        Restaurant myRestaurant = new Restaurant("toto");
        myRestaurant.setClock(fakeCloke);
        boolean isOpen = myRestaurant.isOpen();
        return isOpen;
    }
}
