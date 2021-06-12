package com.faramarz.spring.springcore;


import com.faramarz.spring.springcore.unittest.MyMath;
import org.junit.*;

public class MathTest {

    /**
     * It runs before every test
     */
    @Before
    public void before() {
        //Assert.fail("not ready");
        System.out.println("before");
    }

    /**
     * It runs after every test
     */
    @After
    public void after() {
        //Assert.fail("not ready");
        System.out.println("After");
    }

    /**
     * these methods should be static
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Test
    public void test() {
        //Assert.fail("not ready");
        System.out.println("test");
    }

    @Test
    public void testSum() {
        System.out.println("testSum");
        MyMath math = new MyMath();
        int result = math.sum(new int[]{1, 2, 3});
        //Assert.assertEquals(expected, actual);
        Assert.assertEquals(6, result);

    }


}
