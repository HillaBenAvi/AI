import java.util.List;

public class Minimax implements ISolver {
    @Override
    public String getSolverName() {
        return "Minimax";
    }

    @Override
    public double solve(IBoard board) {
        Node root = new Node(board, Node.NodeType.MAX);
        return MinimaxAlgorithm(root);
    }


    private double MinimaxAlgorithm(Node node)
    {

        double best = 0;
        if(node.isTerminalNode()){
            return node.getScore();
        }
        List<Node> children = node.getNodeChildren();
        if(node.getNodeType() == Node.NodeType.MAX) {
            for (Node child : children) {
                if (MinimaxAlgorithm(child) > best) {
                    best = child.getScore();
                }
            }

        }
        else{
            for (Node child : children) {
                if (MinimaxAlgorithm(child) < best) {
                    best = child.getScore();
                }
            }
        }
        return best;
    }

}
