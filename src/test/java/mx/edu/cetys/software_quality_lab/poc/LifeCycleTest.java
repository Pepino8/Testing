package mx.edu.cetys.software_quality_lab.poc;


import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class LifeCycleTest {
    private static final Logger LOGGER = Logger.getLogger(LifeCycleTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        LOGGER.info("Before All Tests");
    }

    @AfterAll
    static void afterAll() {
        LOGGER.info("After All Tests");
    }

    @BeforeEach
    void beforeEach() {
        LOGGER.info("Before Each Test");
    }

    @AfterEach
    void afterEach() {
        LOGGER.info("After Each Test");
    }

    @Test
    @DisplayName("Miau 🦈")
    void test1() {
        LOGGER.info("This is test1");
    }


    @Test
    void test2() {
        LOGGER.info("This is test2");
    }
}
