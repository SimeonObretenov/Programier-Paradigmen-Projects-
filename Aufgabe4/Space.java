package Aufgabe4;
import java.util.*;

/**
 * Represents a generic space within a structure, with connectivity and accessibility properties.
 *
 * PRE: Spaces must be correctly initialized and connected as per the structural requirements.
 * POST: Space properties and behaviors, such as accessibility, connectivity, and escape mechanisms,
 *       are defined and functional.
 */
public abstract class Space {

    protected LinkedList<Space> next; // List of adjacent spaces.
    protected boolean accesible; // Indicates if the space is accessible.
    protected Entity partOf; // Entity that this space is part of.
    protected Escape escape; // Escape mechanism for this space.

    /**
     * Retrieves the entity this space belongs to, if it is accessible.
     *
     * PRE: None.
     * POST: Returns the entity if accessible, null otherwise.
     *
     * @return The entity this space is part of, or null if inaccessible.
     */
    public Entity entity() {
        return accesible ? partOf : null;
    }

    /**
     * Sets the entity that this space is part of.
     *
     * PRE: The entity must be valid.
     * POST: The space's `partOf` field is updated with the provided entity.
     *
     * @param partOf The entity this space is part of.
     */
    public void setPartOf(Entity partOf) {
        this.partOf = partOf;
    }

    /**
     * Marks this space as accessible.
     *
     * PRE: None.
     * POST: The space is marked as accessible.
     */
    public void makeAccessible() {
        accesible = true;
    }

    /**
     * Retrieves the escape mechanism for this space if it is accessible.
     *
     * PRE: None.
     * POST: Returns the escape mechanism if the space is accessible, null otherwise.
     *
     * @return The escape mechanism or null if inaccessible.
     */
    public Escape escape() {
        return accesible ? escape : null;
    }

    /**
     * Creates a graph representation of the connected spaces.
     *
     * PRE: The graph must be a valid map.
     * POST: Adds this space and its neighbors to the graph if accessible.
     *
     * @param graph A map representing the connectivity of spaces.
     */
    public void createGraph(Map<Space, LinkedList<Space>> graph) {
        if (!accesible) {
            return;
        }

        if (!graph.containsKey(this)) {
            graph.put(this, this.next);
            for (Space neighbor : this.next) {
                neighbor.createGraph(graph);
            }
        }
    }

    /**
     * Checks if this space is accessible.
     *
     * PRE: None.
     * POST: Returns true if the space is accessible, false otherwise.
     *
     * @return True if accessible, false otherwise.
     */
    public boolean isAccesible() {
        return accesible;
    }

    /**
     * Removes this space from accessibility and recalculates connectivity.
     *
     * PRE: The space must be accessible.
     * POST: The space is removed, its neighbors are updated,
     *       and connectivity is recalculated.
     *
     * @return The removed space, or null if it was already inaccessible.
     */
    public Space remove() {
        if (!accesible) {
            return null;
        }
        accesible = false;
        Map<Space, LinkedList<Space>> graph = new HashMap<>();
        createGraph(graph);

        // Remove this space from the graph
        graph.remove(this);
        for (Space neighbor : next) {
            graph.get(neighbor).remove(this);
        }

        // Recalculate connected components
        List<Set<Space>> connectedComponents = findConnectedComponents(graph);
        Space[] connectors = new Space[connectedComponents.size()];
        int j = 0;
        for (Set<Space> set : connectedComponents) {
            for (Space s : set) {
                if (s instanceof Circulation) {
                    connectors[j] = s;
                    j++;
                    break;
                }
            }
        }

        for (j = 0; j < connectors.length - 1; j++) {
            Space s1 = connectors[j];
            Space s2 = connectors[j + 1];
            s1.next.add(s2);
            s2.next.add(s1);
        }

        return this;
    }

    /**
     * Finds all connected components in the graph.
     *
     * PRE: The graph must be valid and non-null.
     * POST: Returns a list of sets, each representing a connected component.
     *
     * @param graph The graph representing spaces and their connectivity.
     * @return A list of connected components as sets of spaces.
     */
    private List<Set<Space>> findConnectedComponents(Map<Space, LinkedList<Space>> graph) {
        Map<Space, Boolean> visited = new HashMap<>();
        for (Space space : graph.keySet()) {
            visited.put(space, false);
        }

        List<Set<Space>> connectedComponents = new ArrayList<>();

        for (Space space : graph.keySet()) {
            if (!visited.get(space)) {
                Set<Space> component = new HashSet<>();
                dfs(space, graph, visited, component);
                connectedComponents.add(component);
            }
        }

        return connectedComponents;
    }

    /**
     * Performs a depth-first search to explore a connected component.
     *
     * PRE: The graph and visited map must be valid.
     * POST: Adds all reachable spaces to the connected component.
     *
     * @param space     The starting space for DFS.
     * @param graph     The graph representing connectivity.
     * @param visited   Map tracking visited spaces.
     * @param component Set to store the current connected component.
     */
    private void dfs(Space space, Map<Space, LinkedList<Space>> graph, Map<Space, Boolean> visited, Set<Space> component) {
        visited.put(space, true);
        component.add(space);

        for (Space neighbor : graph.getOrDefault(space, new LinkedList<>())) {
            if (!visited.get(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}
