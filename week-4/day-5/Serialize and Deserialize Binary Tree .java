public class Codec {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        helper(root, sb);

        return sb.toString();
    }

    private void helper(TreeNode node,
                        StringBuilder sb) {

        if (node == null) {

            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        helper(node.left, sb);
        helper(node.right, sb);
    }

    public TreeNode deserialize(String data) {

        Queue<String> queue =
                new LinkedList<>(Arrays.asList(data.split(",")));

        return build(queue);
    }

    private TreeNode build(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null"))
            return null;

        TreeNode node =
                new TreeNode(Integer.parseInt(value));

        node.left = build(queue);
        node.right = build(queue);

        return node;
    }
}
