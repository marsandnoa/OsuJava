import java.util.Iterator;

import org.junit.Test;

import components.set.Set;
import junit.framework.Assert;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    @Test
    public void testConstructorEmptySet() {
        Set<String> set = this.constructorTest();
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testAdd() {
        Set<String> set = this.constructorTest();
        set.add("a");
        set.add("b");
        set.add("c");
        Assert.assertEquals(3, set.size());
    }

    @Test
    public void testRemoveAny() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        String removed = set.removeAny();
        Assert.assertNotNull(removed);
        Assert.assertFalse(set.contains(removed));
    }

    @Test
    public void testContains() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        Assert.assertTrue(set.contains("b"));
        Assert.assertFalse(set.contains("d"));
    }

    @Test
    public void testSize() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        Assert.assertEquals(3, set.size());
    }

    @Test
    public void testClear() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        set.clear();
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testAddAll() {
        Set<String> set = this.createFromArgsTest("a", "b");
        Set<String> otherSet = this.createFromArgsTest("c", "d");
        set.add(otherSet);
        Assert.assertEquals(4, set.size());
        Assert.assertTrue(set.contains("c"));
        Assert.assertTrue(set.contains("d"));
    }

    @Test
    public void testIterator() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        Iterator<String> iterator = set.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(set.contains(iterator.next()));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(set.contains(iterator.next()));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(set.contains(iterator.next()));
        Assert.assertFalse(iterator.hasNext());
    }

}
