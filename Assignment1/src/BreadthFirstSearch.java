import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	Queue <ASearchNode> openList;
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
		if(openList.contains(node)) {
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
			List<ASearchNode> listOfNeighbors = bestNode.getNeighbors();
			for(int i=0; i<listOfNeighbors.size(); i++){
				ASearchNode neighbor = listOfNeighbors.get(i);
				if(!isOpen(neighbor) && !isClosed(neighbor)){
					addToOpen(listOfNeighbors.get(i));
				}
			}
			addToClosed(bestNode);
			return bestNode;
		}
	}

}