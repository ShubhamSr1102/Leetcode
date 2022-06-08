package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class isTreeSymmetric {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSubTreeSymmetric(root.left, root.right);
	}

	private boolean isSubTreeSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return (left.val == right.val) && isSubTreeSymmetric(left.left, right.right)
				&& isSubTreeSymmetric(left.right, right.left);
	}
	
	public boolean isSymmetricIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode p = queue.poll();
			TreeNode q = queue.poll();
			if(p == null && q == null) continue;
			if(p == null || q == null) return false;
			if(p.val != q.val) return false;
			queue.add(p.left);
			queue.add(q.right);
			queue.add(p.right);
			queue.add(q.left);
		}
		return true;
	}
}
