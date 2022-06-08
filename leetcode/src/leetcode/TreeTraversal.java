package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}

	public List<Integer> inorderTraversalAlt(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				result.add(node.val); // Add after all left children
				p = node.right;
			}
		}
		return result;
	}

//preorder
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			list.add(current.val);
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		return list;
	}

	public List<Integer> preorderTraversalAlt(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.add(p.val); // Add before going to children
				p = p.left;
			} else {
				TreeNode node = stack.pop();
				p = node.right;
			}
		}
		return result;
	}

//postorder
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			list.add(0, curr.val);
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		return list;
	}

	public List<Integer> postorderTraversalAlt(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				result.addFirst(p.val); // Reverse the process of preorder
				p = p.right; // Reverse the process of preorder
			} else {
				TreeNode node = stack.pop();
				p = node.left; // Reverse the process of preorder
			}
		}
		return result;
	}
}
