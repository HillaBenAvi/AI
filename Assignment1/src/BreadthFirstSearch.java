import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	Queue <ASearchNode> openList;
	HashSet <ASearchNode> openListHash;
	ArrayList<ASearchNode> closeList;


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
		if (closeList.contains(node)) {
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
			//List<ASearchNode> listOfNeighbors = bestNode.getNeighbors();
			//for(int i=0; i<listOfNeighbors.size(); i++){
				//ASearchNode neighbor = listOfNeighbors.get(i);
				//if(!isOpen(neighbor) && !isClosed(neighbor)){
				//	addToOpen(listOfNeighbors.get(i));
				//}
			//}
			//addToClosed(bestNode);
			openListHash.remove(bestNode);
			return bestNode;
		}
	}

}