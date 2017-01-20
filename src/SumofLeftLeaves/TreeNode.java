package SumofLeftLeaves;

/**
 * Created by luyan on 17/1/20.
 */
public class TreeNode {

    private  static long sum=0;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        sumOfLeftLeaves(node1);
        System.out.println(sum);

    }

    private static int calc(TreeNode root) {
        if (root.left != null) {
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right);
        }
        return root.val;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        calc(root);
        return (int) sum;
    }
}
