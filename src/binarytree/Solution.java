package binarytree;


import java.util.ArrayList;
import java.util.List;

public class Solution {


    void midTraversal(TreeNode  cur, List<Integer> vec) {
        if (cur == null) return;
        midTraversal(cur.left, vec);  // 左
        vec.add(cur.val);    // 中
        midTraversal(cur.right, vec); // 右
    }

    void preTraversal(TreeNode  cur, List<Integer> vec) {
        if (cur == null) return;
        vec.add(cur.val);    // 中
        preTraversal(cur.left, vec);  // 左
        preTraversal(cur.right, vec); // 右
    }

    List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        midTraversal(root, res);
        return res;
    }


    //求根到叶子节点数字之和
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    //求根到叶子节点数字之和

//----------------------------
    int ans = 0;

    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        int preVal = 0;
        dfs2(root, preVal);
        return ans;
    }

    public void dfs2(TreeNode root, int preVal) {
        preVal = preVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += preVal;
            return;
        }
        if (root.left != null) {
            dfs2(root.left, preVal);
        }
        if (root.right != null) {
            dfs2(root.right, preVal);
        }
    }

}