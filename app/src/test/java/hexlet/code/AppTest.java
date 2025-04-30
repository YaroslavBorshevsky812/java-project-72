package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.App.stringTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {

    @Test
    public void testStringTest() {
        assertEquals("Hello", stringTest("Hello"));

        assertEquals("", stringTest(""));

        assertNull(stringTest(null));

        assertEquals("123\n\t", stringTest("123\n\t"));
    }
}
