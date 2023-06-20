package test.homework7;

import org.junit.Test;

import code.homework7.easy.Easy;

public class EasyTest extends TestBase {

    @Test
    public void testSimple() {
        Easy object = new Easy(10, "Ivan Ivanov", 40.0);
        testToString(object, "{age: 10, name: Ivan Ivanov, weight: 40.0}");
    }

    @Test
    public void testNullField() {
        Easy object = new Easy(10, null, 40.0);
        testToString(object, "{age: 10, name: null, weight: 40.0}");
    }

    @Test
    public void testEmptyName() {
        Easy object = new Easy(10, "", 40.0);
        testToString(object, "{age: 10, name: , weight: 40.0}");
    }
}
