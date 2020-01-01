import java.util.List;

public class AlphaBetaPruning implements ISolver {
    @Override
    public String getSolverName() {
        return "Alpha-Beta Pruning";
    }

    @Override
    public double solve(IBoard board) {
        Node root = new Node(board, Node.NodeType.MAX);
        return AlphaBetaPruningAlgorithm(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }


    private double AlphaBetaPruningAlgorithm(Node node, double p_alpha, double p_beta) {
        if(node.isTerminalNode()){
            return node.getScore();
        }
        double value;
        List <Node> children = node.getNodeChildren();
        if(node.getNodeType() == Node.NodeType.MAX){
            value = -Double.MAX_VALUE;
            for(Node child : children){
                value = Math.max(value, AlphaBetaPruningAlgorithm(child, p_alpha, p_beta));
                p_alpha=Math.max(p_alpha, value);
                if(p_alpha>=p_beta){
                    return value;
                }
            }
        }
        else {
            value = Double.MAX_VALUE;
            for(Node child : children){
                value = Math.min(value, AlphaBetaPruningAlgorithm(child, p_alpha, p_beta));
                p_beta=Math.min(p_beta, value);
                if(p_alpha>=p_beta){
                    return value;
                }
            }
        }
        return value;
    }

}
