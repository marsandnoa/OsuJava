import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;

/**
 * JUnit test fixture for {@code BinarySearchTreeMethods}'s static methods
 * isInTree (and removeSmallest).
 */
public final class BinarySearchTreeMethodsTest {

    /**
     * Constructs and return a BST created by inserting the given {@code args}
     * into an empty tree in the order in which they are provided.
     *
     * @param args
     *            the {@code String}s to be inserted in the tree
     * @return the BST with the given {@code String}s
     * @requires [the Strings in args are all distinct]
     * @ensures createBSTFromArgs = [the BST with the given Strings]
     */
    private static BinaryTree<String> createBSTFromArgs(String... args) {
        BinaryTree<String> t = new BinaryTree1<String>();
        for (String s : args) {
            BinaryTreeUtility.insertInTree(t, s);
        }
        return t;
    }

    @Test
    public void sampleTest() {
        /*
         * Set up variables
         */
        BinaryTree<String> t1 = createBSTFromArgs("b", "a", "c");
        BinaryTree<String> t2 = createBSTFromArgs("b", "a", "c");
        /*
         * Call method under test
         */
        boolean inTree = BinarySearchTreeMethods.isInTree(t1, "a");
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(true, inTree);
        assertEquals(t2, t1);
    }

    @Test
    public void testIsInTree_labelPresent_returnsTrue() {
        /*
         * Test: Search for a label that is present in the tree
         */
        BinaryTree<String> t = createBSTFromArgs("b", "a", "c");
        boolean inTree = BinarySearchTreeMethods.isInTree(t, "a");
        assertEquals(true, inTree);
    }

    @Test
    public void testIsInTree_labelNotPresent_returnsFalse() {
        /*
         * Test: Search for a label that is not present in the tree
         */
        BinaryTree<String> t = createBSTFromArgs("b", "a", "c");
        boolean inTree = BinarySearchTreeMethods.isInTree(t, "d");
        assertEquals(false, inTree);
    }

    @Test
    public void testIsInTree_emptyTree_returnsFalse() {
        /*
         * Test: Search for a label in an empty tree
         */
        BinaryTree<String> t = createBSTFromArgs();
        boolean inTree = BinarySearchTreeMethods.isInTree(t, "a");
        assertEquals(false, inTree);
    }

    @Test
    public void testIsInTree_labelPresent_differentDataTypes_returnsTrue() {
        /*
         * Test: Search for a label of a different data type that is present in
         * the tree
         */
        BinaryTree<String> t = createBSTFromArgs("5", "3", "7", "2", "4", "6",
                "8");
        boolean inTree = BinarySearchTreeMethods.isInTree(t, "4");
        assertEquals(true, inTree);
    }

    @Test
    public void testIsInTree_labelNotPresent_differentDataTypes_returnsFalse() {
        /*
         * Test: Search for a label of a different data type that is not present
         * in the tree
         */
        BinaryTree<String> t = createBSTFromArgs("5", "3", "7", "2", "4", "6",
                "8");
        boolean inTree = BinarySearchTreeMethods.isInTree(t, "10");
        assertEquals(false, inTree);
    }

    @Test
    public void testRemoveSmallest_nonEmptyTree_removesSmallestLabel() {
        /*
         * Test: Remove the smallest label from a non-empty tree
         */
        BinaryTree<String> t = createBSTFromArgs("b", "a", "c");
        String smallest = BinarySearchTreeMethods.removeSmallest(t);
        assertEquals("a", smallest);
    }

    @Test
    public void testRemoveSmallest_singleNodeTree_removesSingleNode() {
        /*
         * Test: Remove the smallest label from a tree with only one node
         */
        BinaryTree<String> t = createBSTFromArgs("a");
        String smallest = BinarySearchTreeMethods.removeSmallest(t);
        assertEquals("a", smallest);
    }

    @Test
    public void testRemoveSmallest_removeAllLabels_singleNodeTree() {
        /*
         * Test: Remove the only label from a single-node tree
         */
        BinaryTree<String> t = createBSTFromArgs("a");
        String removed = BinarySearchTreeMethods.removeSmallest(t);
        assertEquals("a", removed);
        assertEquals(0, t.size());
    }

}
