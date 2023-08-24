import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAdd2() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "Test");
        sExpected.add(0, "Test");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAdd4() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "1");
        s.add(0, "2");
        s.add(0, "3");
        s.add(0, "4");

        sExpected.add(0, "1");
        sExpected.add(0, "2");
        sExpected.add(0, "3");
        sExpected.add(0, "4");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testAddMiddle() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "1");
        s.add(1, "2");
        s.add(2, "3");
        s.add(3, "4");

        sExpected.add(0, "1");
        sExpected.add(1, "2");
        sExpected.add(2, "3");
        sExpected.add(3, "4");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveMiddle() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "1");
        s.add(1, "2");
        s.add(0, "3");
        s.add(1, "4");
        s.remove(2);

        sExpected.add(0, "1");
        sExpected.add(1, "2");
        sExpected.add(0, "3");
        sExpected.add(1, "4");
        sExpected.remove(2);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveFirst() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "1");
        s.add(1, "2");
        s.add(0, "3");
        s.add(1, "4");
        s.remove(0);

        sExpected.add(0, "1");
        sExpected.add(1, "2");
        sExpected.add(0, "3");
        sExpected.add(1, "4");
        sExpected.remove(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testRemoveLast() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();
        s.add(0, "1");
        s.add(1, "2");
        s.add(0, "3");
        s.add(1, "4");
        s.remove(s.length() - 1);

        sExpected.add(0, "1");
        sExpected.add(1, "2");
        sExpected.add(0, "3");
        sExpected.add(1, "4");
        sExpected.remove(sExpected.length() - 1);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    @Test
    public final void testLenEmpty() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.length(), s.length());
    }

    @Test
    public final void testLenOne() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();

        s.add(0, "1");

        sExpected.add(0, "1");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.length(), s.length());
    }

    @Test
    public final void testLenTwo() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> s = this.constructorTest();
        Sequence<String> sExpected = this.constructorRef();

        s.add(0, "1");
        s.add(0, "1");

        sExpected.add(0, "1");
        sExpected.add(0, "1");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected.length(), s.length());
    }
}
