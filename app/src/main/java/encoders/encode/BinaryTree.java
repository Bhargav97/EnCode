package encoders.encode;


public class BinaryTree {
    TreeNode root;

    StringBuilder inorder, postorder, preorder;

    BinaryTree(){
        inorder = new StringBuilder("");
        preorder = new StringBuilder("");
        postorder = new StringBuilder("");
    }

    TreeIndex index = new TreeIndex();

    // A recursive function to construct Full from pre[]. preIndex is used
    // to keep track of index in pre[].
    TreeNode constructTreeUtilFromPre(int pre[], TreeIndex preIndex,
                           int low, int high, int size) {

        // Base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
        TreeNode root = new TreeNode(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        // If the current subarry has only one element, no need to recur
        if (low == high) {
            return root;
        }

        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        // Use the index of element found in preorder to divide preorder array in
        // two parts. Left subtree and right subtree
        root.left = constructTreeUtilFromPre(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtilFromPre(pre, preIndex, i, high, size);

        return root;
    }

    // The main function to construct BST from given preorder traversal.
    // This function mainly uses constructTreeUtil()
    TreeNode constructTreeFromPre(int pre[], int size) {
        return constructTreeUtilFromPre(pre, index, 0, size - 1, size);
    }

    TreeNode constructTreeUtilFromPost(int post[], TreeIndex postIndex,
                           int key, int min, int max, int size)
    {
        // Base case
        if (postIndex.postindex < 0)
            return null;

        TreeNode root = null;

        // If current element of post[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max)
        {
            // Allocate memory for root of this subtree and decrement
            // *postIndex
            root = new TreeNode(key);
            postIndex.postindex = postIndex.postindex - 1;

            if (postIndex.postindex > 0)
            {
                // All nodes which are in range {key..max} will go in
                // right subtree, and first such node will be root of right
                // subtree
                root.right = constructTreeUtilFromPost(post, postIndex,
                        post[postIndex.postindex],key, max, size);

                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtilFromPost(post, postIndex,
                        post[postIndex.postindex],min, key, size);
            }
        }
        return root;
    }

    // The main function to construct BST from given postorder
    // traversal. This function mainly uses constructTreeUtil()
    TreeNode constructTreeFromPost(int post[], int size)
    {
        TreeIndex index = new TreeIndex();
        index.postindex = size - 1;
        return constructTreeUtilFromPost(post, index, post[index.postindex],
                Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }
    /* Recursive function to construct binary of size len from
       Inorder traversal inorder[]. Initial values of start and end
       should be 0 and len -1.  */
    TreeNode constructTreeFromIn(int inorder[], int start, int end, TreeNode node)
    {
        if (start > end)
            return null;

        /* Find index of the maximum element from Binary Tree */
        int i = max(inorder, start, end);

        /* Pick the maximum value and make it root */
        node = new TreeNode(inorder[i]);

        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end)
            return node;

        /* Using index in Inorder traversal, construct left and
         right subtress */
        node.left = constructTreeFromIn(inorder, start, i - 1, node.left);
        node.right = constructTreeFromIn(inorder, i + 1, end, node.right);

        return node;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of the maximum value in arr[start...end] */
    int max(int arr[], int strt, int end)
    {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }

    // A utility function to print inorder traversal of a Binary Tree
    void genInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        genInorder(node.left);
        inorder.append(" =>"+ node.data);
        genInorder(node.right);
    }
    void genPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preorder.append(" =>"+ node.data);
        genPreorder(node.left);
        genPreorder(node.right);
    }
    void genPostorder(TreeNode node) {
        if (node == null) {
            return;
        }
        genPostorder(node.left);
        genPostorder(node.right);
        postorder.append(" =>"+ node.data);
    }
}
