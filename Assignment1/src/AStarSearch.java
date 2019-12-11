import java.util.*;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	PriorityQueue <ASearchNode> openList;
	HashSet<ASearchNode> hashOpenList;
	HashSet <ASearchNode> closeList;

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
		hashOpenList = new HashSet<>();
		closeList = new HashSet<>();
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
		if(hashOpenList.contains(node)){
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
		hashOpenList.add(node);
		openList.add(node);
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
		if( openList.size() == 0 ){
			return null;
		}
		ASearchNode node = openList.poll();
		hashOpenList.remove(node);
		return node;
	}


	class TheComparator implements Comparator<ASearchNode> {
		public int compare(ASearchNode node1, ASearchNode node2)
		{
			if(node1.F() > node2.F()){
				return 1;
			}
			else if(node1.F() < node2.F()) {
				return -1;
			}
			return 0;
		}
	}
}
