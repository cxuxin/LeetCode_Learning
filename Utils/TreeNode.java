package Utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode buildTree(char[] treeList, int i, int n){
        if (i >= n || treeList[i] == '#') {
            return null;
        }
        TreeNode root = new TreeNode(treeList[i] - '0');
        root.left = buildTree(treeList, 2*i + 1, n);
        root.right = buildTree(treeList, 2*i+2, n);
        return root;
    }
}
