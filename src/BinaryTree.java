public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   public BinaryTree(String pre, String in){
      //BinaryNode<String> x = new BinaryNode<>(preorder[0]);
      String temp;
      String temp2;
      BinaryTree<String> x = new BinaryTree<>(pre.substring(0, 1));
      
   }

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData
   
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty
   
   public void clear()
   {
      root = null;
   } // end clear
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode
   
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if
      
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree
   
   /** -------------------------------------------------------------------- */
   /** Task 1: Implement the 4 methods
    *     . In BinaryTree.java
    *          1. public void postorderTraverse();
    *          2. private void postorderTraverse(BinaryNode<T> node)
    *          3. public void postorderTraverse_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          4. public void postorderTraverse_binaryNodeMethod() */
   
   /** calls postorderTraverse(BinaryNode<T> node)
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse()
   {
      postorderTraverse(root);
   }
   
   /** A Recursive Method in the BinaryTree Class   
    * prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private void postorderTraverse(BinaryNode<T> node)
   {  
      if (node != null){
         postorderTraverse(node.getLeftChild());
         postorderTraverse(node.getRightChild());
         System.out.println(node.getData());
      }
   }
 
   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method   
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse_callBinaryNodeMethod()
   {
      if (root != null){
         root.postorderTraverse_binaryNodeMethod();
      }
      //root.postorderTraverse_binaryNodeMethod();
   }
   
   /** -------------------------------------------------------------------- */
   /** Task 2: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getHeight_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          2. public int getHeight_binaryNodeMethod()*/
   
   /** calls getHeight(BinaryNode<T> node)
   @return  The height of the "whole" tree */
   public int getHeight()
   {
	   return getHeight(root);
   } // end getHeight
   
   /** A Recursive Method in the BinaryTree Class  
    * Computes the height of the subtree rooted at this node.
   @return  The height of the subtree rooted at this node. */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                               getHeight(node.getRightChild()));
      return height;
   } // end getHeight
   
   /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
    * Computes the height of the "whole" tree.
   @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
	   return root.getHeight_binaryNodeMethod();
   } // end getHeight_callBinaryNodeMethod

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/
   
   /** calls getNumberOfNodes(BinaryNode<T> node) 
   @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      return getNumberOfNodes(root);
   } // end getNumberOfNodes
   
   /** A Recursive Method in the BinaryTree Class   
    * Counts the nodes in the subtree rooted at this node.
   @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      int leftnum = 0;
      int rightnum = 0;
      if (node.getLeftChild() != null){
         leftnum = getNumberOfNodes(node.getLeftChild());
      }
      if (node.getRightChild() != null){
         rightnum = getNumberOfNodes(node.getRightChild());
      }
      return 1 + leftnum + rightnum;
   } // end getNumberOfNodes
   
   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * Counts the nodes in the "whole" tree
   @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod

   //Versions that return a string so that it can be tested
   protected String testpostOrderTraverse(BinaryNode<T> node){
      String x = "";
      if (node != null){
         x += testpostOrderTraverse(node.getLeftChild());
         x += testpostOrderTraverse(node.getRightChild());
         x += node.getData();
      }
      return x;
   }

   protected String testpostorderTraverseCallNode(){
      return root.testpostorderTraverse_binaryNodeMethod();
   }
   
} // end BinaryTree

/*
String[] preorder = new String[pre.length()];
String[] inorder = new String[in.length()];

for (int i = 0; i < preorder.length; i++){
   if (i != preorder.length - 1){
      preorder[i] = pre.substring(i, i + 1);
   }
   else{
      preorder[i] = pre.substring(i);
   }
}

for (int i = 0; i < inorder.length; i++){
   if (i != inorder.length - 1){
      inorder[i] = in.substring(i, i + 1);
   }
   else{
      inorder[i] = in.substring(i);
   }
}
*/
/*
      //BinaryNode<String> x = new BinaryNode<>(preorder[0]);
      String temp;
      String temp2;
      BinaryTree<String> x = new BinaryTree<>(pre.substring(0, 1));
      for (int i = 0; i < in.indexOf(pre.substring(0, 1)); i++){
         if (i != in.length() - 1){
            temp += in.substring(i, i + 1);
         }
         else{
            temp += in.substring(i);
         }
      }
      boolean finished = false;
      for (int i = 0; i < temp.length() && !finished; i++){
         for (int j = 0; j < in.length(); j++){
            if (j != in.length() - 1 && i != temp.length() - 1){
               if (in.substring(j, j + 1).equals(temp.substring(i, i + 1))){
                  BinaryTree<String> y = new BinaryTree<>()
               }
            }
         }
      }
      x.getRootNode().setLeftChild();
      //BinaryTree<String> y = new BinaryTree<>(preorder[0]);
      initializeTree(pre, x, y);
      */