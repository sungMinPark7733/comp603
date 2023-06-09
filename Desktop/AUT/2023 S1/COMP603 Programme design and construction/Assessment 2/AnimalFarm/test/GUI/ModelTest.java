package GUI;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest {

    private Model model;

    public ModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        model = new Model();
    }

    @After
    public void tearDown() {
    }

    // Test adding hungry chicken successfully
    @Test
    public void testAddHungryChicken_Success() {
        int initialChickenCount = model.getAnimals().size();
        int initialHungryChickenCount = model.getHungryChickenNumber();
        int initialCoin = model.getCoin();

        model.addHungryChicken();

        assertEquals(initialChickenCount + 1, model.getAnimals().size());
        assertEquals(initialHungryChickenCount + 1, model.getHungryChickenNumber());
        assertEquals(initialCoin - new chicken().cost, model.getCoin());
    }

    // Test adding hungry chicken when there is insufficient coin
    @Test
    public void testAddHungryChicken_InsufficientCoin() {
        int initialChickenCount = model.getAnimals().size();
        int initialHungryChickenCount = model.getHungryChickenNumber();
        int initialCoin = model.getCoin();
        model.setCoin(1);

        model.addHungryChicken();

        assertEquals(initialChickenCount, model.getAnimals().size());
        assertEquals(initialHungryChickenCount, model.getHungryChickenNumber());
        assertEquals(initialCoin, model.getCoin());
    }

    // Test adding multiple hungry chickens
    @Test
    public void testAddHungryChicken_MultipleChickens() {
        int initialChickenCount = model.getAnimals().size();
        int initialHungryChickenCount = model.getHungryChickenNumber();
        int initialCoin = model.getCoin();

        model.addHungryChicken();
        model.addHungryChicken();
        model.addHungryChicken();

        assertEquals(initialChickenCount + 3, model.getAnimals().size());
        assertEquals(initialHungryChickenCount + 3, model.getHungryChickenNumber());
        assertEquals(initialCoin - (new chicken().cost * 3), model.getCoin());
    }

    // Test observer notification when adding hungry chicken
    @Test
    public void testAddHungryChicken_ObserverNotification() {
        TestObserver observer = new TestObserver();
        model.addObserver(observer);

        model.addHungryChicken();

        assertTrue(observer.isNotified());
        assertEquals(model.getAnimals(), observer.getUpdatedAnimals());
    }

    // Test coin balance after adding hungry chicken
    @Test
    public void testAddHungryChicken_CoinBalance() {
        int initialCoin = model.getCoin();

        model.addHungryChicken();

        assertEquals(initialCoin - new chicken().cost, model.getCoin());
    }

    // Helper class for testing observer notification
    private static class TestObserver implements java.util.Observer {

        private boolean notified = false;
        private ArrayList<Animal> updatedAnimals;

        public boolean isNotified() {
            return notified;
        }

        public ArrayList<Animal> getUpdatedAnimals() {
            return updatedAnimals;
        }

        @Override
        public void update(java.util.Observable o, Object arg) {
            notified = true;
            if (arg instanceof ArrayList<?>) {
                updatedAnimals = (ArrayList<Animal>) arg;
            }
        }
    }
}
