package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
	public int run(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int dept = 0;
		if (root == null)
			return 0;
		q.offer(root);
		while (!q.isEmpty()) {
			dept++;
			int size = q.size();
			for(int i =0;i<size;i++){
				TreeNode poll = q.poll();
				if (poll.left == null && poll.right == null) {
					return dept;
				}
				if (poll.left != null) {
					q.offer(poll.left);
				}
				if (poll.right != null) {
					q.offer(poll.right);
				}
			}

		}
		return dept;
	}

}
