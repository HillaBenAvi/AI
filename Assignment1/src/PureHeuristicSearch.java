import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PureHeuristicSearch  extends ASearch
{
	PriorityQueue<ASearchNode> openList;
	HashSet<ASearchNode> hashOpenList;
	ArrayList<ASearchNode> closedList;
	HashSet<ASearchNode> hashClosedList;
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		TopSpinPuzzleState problemState
	) 
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		PureHeuristicSearch.HComparator comparator = new PureHeuristicSearch.HComparator();
		openList = new PriorityQueue(16, comparator);
		hashOpenList = new HashSet<>();
		closedList = new ArrayList<>();
		hashClosedList = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if (hashOpenList.contains(node)){
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return hashOpenList.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return hashClosedList.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		openList.add(node);
		hashOpenList.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		closedList.add(node);
		hashClosedList.add(node);
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

	class HComparator implements Comparator<ASearchNode> {
		public int compare(ASearchNode node1, ASearchNode node2)
		{
			if(node1.H() < node2.H()){
				return 1;
			}
			else if(node1.H() > node2.H()) {
				return -1;
			}
			return 0;
		}
	}

}