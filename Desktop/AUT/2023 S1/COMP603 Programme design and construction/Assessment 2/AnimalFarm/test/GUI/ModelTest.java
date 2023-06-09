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
        assertEquals(initialCoin - new chicken().getCost(), model.getCoin());
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
        assertEquals(initialCoin - (new chicken().getCost() * 3), model.getCoin());
    }

    // Test coin balance after adding hungry chicken
    @Test
    public void testAddHungryChicken_CoinBalance() {
        int initialCoin = model.getCoin();

        model.addHungryChicken();

        assertEquals(initialCoin - new chicken().getCost(), model.getCoin());
    }
// Test adding hungry chicken with sufficient coin

    @Test
    public void testAddHungryChicken_SufficientCoin() {
        int initialChickenCount = model.getAnimals().size();
        int initialHungryChickenCount = model.getHungryChickenNumber();
        int initialCoin = model.getCoin();

        model.addHungryChicken();

        assertEquals(initialChickenCount + 1, model.getAnimals().size());
        assertEquals(initialHungryChickenCount + 1, model.getHungryChickenNumber());
        assertEquals(initialCoin - new chicken().getCost(), model.getCoin());
    }
// Test selling chicken and updating coin balance

    @Test
    public void testSellChicken_CoinBalance() {
        model.addHungryChicken(); // Add a hungry chicken
        int initialCoin = model.getCoin();

        model.sellChicken(); // Sell the chicken

        assertEquals(initialCoin + 2, model.getCoin()); // Verify the updated coin balance
    }

// Test adding multiple hungry chickens with sufficient coin
    @Test
    public void testAddHungryChicken_MultipleChickens_SufficientCoin() {
        int initialChickenCount = model.getAnimals().size();
        int initialHungryChickenCount = model.getHungryChickenNumber();
        int initialCoin = model.getCoin();

        model.addHungryChicken();
        model.addHungryChicken();
        model.addHungryChicken();

        assertEquals(initialChickenCount + 3, model.getAnimals().size());
        assertEquals(initialHungryChickenCount + 3, model.getHungryChickenNumber());
        assertEquals(initialCoin - (new chicken().getCost() * 3), model.getCoin());
    }

// Test adding hungry chicken without observer notification
    @Test
    public void testAddHungryChicken_WithoutObserverNotification() {
        TestObserver observer = new TestObserver();
        model.deleteObserver(observer);

        model.addHungryChicken();

        assertFalse(observer.isNotified());
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
