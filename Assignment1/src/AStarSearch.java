import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	PriorityQueue <HeuristicSearchNode> openList;
	ArrayList <ASearchNode> closeList;

	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot(TopSpinPuzzleState problemState)
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists() 
	{
		TheComparator comparator = new TheComparator();
		openList = new PriorityQueue(11, comparator);
		closeList = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if(isOpen(node)){
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if(openList.contains(node)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		if(closeList.contains(node)){
			return true;
		}
		return false;
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		openList.add((HeuristicSearchNode)node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		closeList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest()
	{
		return openList.poll();
	}


	class TheComparator implements Comparator<ASearchNode> {
		public int compare(ASearchNode node1, ASearchNode node2)
		{
			if(node1.F() < node2.F()){
				return -1;
			}
			else if(node1.F() > node2.F()) {
				return 1;
			}
			return 0;
		}
	}
}
