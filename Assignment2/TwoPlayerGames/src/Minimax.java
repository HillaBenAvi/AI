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
        double childMiniMaxScore;
        if(node.isTerminalNode()){
            return node.getScore();
        }
        List<Node> children = node.getNodeChildren();
        if(node.getNodeType() == Node.NodeType.MAX) {
            double best = MinimaxAlgorithm(children.get(0));
            for (int i=1; i<children.size(); i++) {
                childMiniMaxScore = MinimaxAlgorithm(children.get(i));
                if (childMiniMaxScore > best) {
                    best = childMiniMaxScore;
                }
            }
            return best;
        }
        else {
            double best = MinimaxAlgorithm(children.get(0));
            for (int i=1; i<children.size(); i++) {
                childMiniMaxScore = MinimaxAlgorithm(children.get(i));
                if (childMiniMaxScore < best) {
                    best = childMiniMaxScore;
                }
            }
            return best;
        }
    }

}
