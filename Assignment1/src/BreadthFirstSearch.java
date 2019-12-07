import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	Queue <ASearchNode> openList;
	HashSet <ASearchNode> openListHash;
	ArrayList<ASearchNode> closeList;
	HashSet <ASearchNode> closeListHash;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot(TopSpinPuzzleState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		openList = new LinkedList<> ();
		openListHash = new HashSet<>();
		closeList = new ArrayList<>();
		closeListHash = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if(isOpen(node)){
			return node;
		}
		else{
			return null;
		}
	}

	@Override
	public boolean isOpen (ASearchNode node)
	{
		if(openListHash.contains(node)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		if (closeListHash.contains(node)) {
			return true;
		}
		return false;
	}


	@Override
	public void addToOpen(ASearchNode node)
	{
		openList.add(node);
		openListHash.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		closeList.add(node);
		closeListHash.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		if(openSize() == 0){
			return null;
		}
		else{
			ASearchNode bestNode = openList.poll();
			openListHash.remove(bestNode);
			return bestNode;
		}
	}

}