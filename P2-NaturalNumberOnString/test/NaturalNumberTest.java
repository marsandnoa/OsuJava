import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    @Test
    public final void testEmptyConstructor() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest();
        NaturalNumber sExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testIntConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(0);
        NaturalNumber sExpected = this.constructorRef(0);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testIntConstructorNormal1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(5);
        NaturalNumber sExpected = this.constructorRef(5);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testIntConstructorNormal2() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(25);
        NaturalNumber sExpected = this.constructorRef(25);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testStringConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.toString(), s.toString());
    }

    @Test
    public final void testStringConstructorNormal1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("5");
        NaturalNumber sExpected = this.constructorRef("5");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.toString(), s.toString());
    }

    @Test
    public final void testStringConstructorNormal2() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("59");
        NaturalNumber sExpected = this.constructorRef("59");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.toString(), s.toString());
    }

    @Test
    public final void testNNConstructorZero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorRef("0"));
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testNNConstructorNormal1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorRef("59"));
        NaturalNumber sExpected = this.constructorRef("59");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testNNConstructorNormal2() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest(this.constructorRef("59"));
        NaturalNumber sExpected = this.constructorRef("59");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testMultiplyBy10Zero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        s.multiplyBy10(0);
        sExpected.multiplyBy10(0);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testMultiplyBy10Normal1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("5");
        NaturalNumber sExpected = this.constructorRef("5");
        /*
         * Assert that values of variables match expectations
         */
        s.multiplyBy10(5);
        sExpected.multiplyBy10(5);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testMultiplyBy10Normal2() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("25");
        NaturalNumber sExpected = this.constructorRef("25");
        /*
         * Assert that values of variables match expectations
         */
        s.multiplyBy10(5);
        sExpected.multiplyBy10(5);
        assertEquals(sExpected, s);
    }

    @Test
    public final void testDivideBy10Zero() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        s.divideBy10();
        sExpected.divideBy10();
        assertEquals(sExpected, s);
    }

    @Test
    public final void testDivideBy10SingleChar() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("5");
        NaturalNumber sExpected = this.constructorRef("5");
        /*
         * Assert that values of variables match expectations
         */
        s.divideBy10();
        sExpected.divideBy10();
        assertEquals(sExpected, s);
    }

    @Test
    public final void testDivideBy10MultipleChar() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("55");
        NaturalNumber sExpected = this.constructorRef("55");
        /*
         * Assert that values of variables match expectations
         */
        s.divideBy10();
        sExpected.divideBy10();
        assertEquals(sExpected, s);
    }

    @Test
    public final void testIsZero1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("55");
        NaturalNumber sExpected = this.constructorRef("55");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.isZero(), s.isZero());
    }

    @Test
    public final void testIsZero2() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber s = this.constructorTest("0");
        NaturalNumber sExpected = this.constructorRef("0");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.isZero(), s.isZero());
    }
}
