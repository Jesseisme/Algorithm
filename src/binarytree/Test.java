package binarytree;

import java.util.ArrayList;
public class Test {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList a = new ArrayList();
        if(root.left!=null){
            postorderTraversal(root.left);
        }
        if(root.right!=null){
            postorderTraversal(root.right);
        }
        a.add(root.val);
        return a;
    }
}
