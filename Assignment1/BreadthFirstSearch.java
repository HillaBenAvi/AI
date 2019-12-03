
public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		TopSpinPuzzleState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{

	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return false;
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return false;
	}

	

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{

	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{

	}

	@Override
	public int openSize() 
	{
		return 0;
	}

	@Override
	public ASearchNode getBest() 
	{
		return null;
	}

}