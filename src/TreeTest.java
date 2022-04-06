import org.junit.jupiter.api.Test;

//import;

import static org.junit.Assert.assertEquals;

public class TreeTest {
    @Test
    void postorderTraverseTest(){
        BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        String actual = aTree.testpostOrderTraverse(aTree.getRootNode());
        String expected = "DEBGFCA";
        assertEquals(expected, actual);

    }

    @Test
    void postorderTraverseNodeTest(){
        BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        String actual = aTree.testpostorderTraverseCallNode();
        String expected = "DEBGFCA";
        assertEquals(expected, actual);

    }

    @Test
    void getHeightTest(){
        BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        int actual = aTree.getHeight_callBinaryNodeMethod();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void getNumberOfNodesTest(){
        BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

        BinaryTree<String> aTree = new BinaryTree<>("A", bTree, cTree);

        int actual = aTree.getNumberOfNodes();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    void createTree2Test(){
        BinaryTree<String> testingtree = new BinaryTree<>();

        DriverBT.createTree2(testingtree);
        String actual = testingtree.testpostOrderTraverse(testingtree.getRootNode());

        String expected = "BFDGHECA";

        assertEquals(expected, actual);

    }
}
