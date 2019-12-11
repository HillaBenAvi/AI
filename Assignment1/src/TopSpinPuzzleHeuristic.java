
public class TopSpinPuzzleHeuristic
{
	public double getHeuristic (TopSpinPuzzleState problemState) {
		double heuristicValue = 0;
		int [] currentGame = problemState._TopSpinPuzzle;
		for(int i=0; i<currentGame.length-2; i++){
			if(currentGame[i+1]-currentGame[i] != 1 && currentGame[i+1]-currentGame[i] != -9){
				if (currentGame[i] > currentGame[i+1]){
					heuristicValue = heuristicValue +currentGame[i+1];
				}
				else{
					heuristicValue = heuristicValue +currentGame[i];
				}
			}
		}
		if(currentGame[0]-currentGame[currentGame.length-1] != 1 && currentGame[0]-currentGame[currentGame.length-1] != -9){
			heuristicValue = heuristicValue + Math.min(currentGame[0], currentGame[currentGame.length-1]);
		}
		return heuristicValue;
	}
}
