package shared;

import java.util.ArrayDeque;
import java.util.Deque;

public class Utils {
    public static void main(String[] args) {
        TreeNode treeNode = makeTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(treeNode);
    }

    public static TreeNode makeTree(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer[]> pairQueue = new ArrayDeque<>();
        nodeStack.push(root);
        for (int i = 1; i < array.length - 1; i += 2) {
            Integer[] newPair = {array[i], array[i + 1]};
            pairQueue.add(newPair);
            TreeNode node = nodeStack.pop();
            Integer[] pair = pairQueue.remove();
            if (pair[1] != null) {
                node.right = new TreeNode(pair[1]);
                nodeStack.push(node.right);
            }
            if (pair[0] != null) {
                node.left = new TreeNode(pair[0]);
                nodeStack.push(node.left);
            }
        }
        return root;
    }
}
