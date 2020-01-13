import java.util.List;
import java.util.Map;

public class BellmanUpdate {

    public static double getNewV(CoffeeWorldState state, OpenCoffeeEnvironment openEnvironment, double discountFactor, Map<CoffeeWorldState, Double> vValues) {

        // TODO: Compute the new V value for the given state.

        // Helper values:
        List<CoffeeWorldAction> legalActions = openEnvironment.getLegalActions(state);
        CoffeeWorldAction action = legalActions.get(0); // An example of one action
        List<OpenCoffeeEnvironment.Transition> transitions = openEnvironment.getLegalTransitions(state,action);

        return 0;
    }

}
