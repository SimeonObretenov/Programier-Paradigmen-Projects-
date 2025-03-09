package Aufgabe4;
import java.util.*;

/**
 * Represents an escape mechanism for a specific space.
 *
 * PRE: The associated space must be valid and part of a connected graph of spaces.
 * POST: Escape paths are calculated and validated based on the space's accessibility and criteria.
 */
public class Escape {

    private Space s; // The space associated with this escape mechanism.
    private Deque<Space> path; // The path representing the escape route.

    /**
     * Constructs an Escape instance for the specified space.
     *
     * PRE: The space must be valid and accessible.
     * POST: Initializes the escape mechanism and validates the room.
     *
     * @param s The space for which the escape mechanism is created.
     * @throws IllegalStateException If the space is too far from a PublicRoad.
     */
    public Escape(Space s) {
        this.s = s;
        path = new ArrayDeque<>();
        roomValidation();
    }

    /**
     * Returns the space associated with this escape mechanism.
     *
     * PRE: None.
     * POST: Returns the associated space.
     *
     * @return The space for this escape mechanism.
     */
    public Space space() {
        return s;
    }

    /**
     * Creates an iterator for the escape path based on specified parameters.
     *
     * PRE: The space must be part of a connected graph.
     * POST: Returns an iterator for the calculated escape path.
     *
     * @param lift Whether to include lifts in the path.
     * @param enter Whether to allow entry to the space.
     * @return An iterator over the escape path.
     */
    public Iterator<Space> iterator(boolean lift, boolean enter) {
        Map<Space, LinkedList<Space>> graph = new HashMap<>();
        s.createGraph(graph);
        bfs(graph, s, lift, enter);
        return path.iterator();
    }

    /**
     * Validates the room's escape conditions.
     *
     * PRE: The space must be valid and part of a connected graph.
     * POST: Ensures the escape path is within acceptable distance constraints.
     *
     * @throws IllegalStateException If the space is too far from a PublicRoad.
     */
    private void roomValidation() {
        Map<Space, LinkedList<Space>> graph = new HashMap<>();
        s.createGraph(graph);
        boolean lift = false;
        for (int i = 0; i < 2; i++) {
            bfs(graph, s, lift, true);
            if (path.size() > 10) {
                throw new IllegalStateException("Space is too far from the Public Road");
            }
            path = new ArrayDeque<>();
            lift = !lift;
        }
        path = new ArrayDeque<>();
    }

    /**
     * Performs a breadth-first search (BFS) to find an escape path.
     *
     * PRE: The graph must be valid, and the starting space must be accessible.
     * POST: Calculates the escape path and updates the `path` field.
     *
     * @param graph The graph representing the connectivity of spaces.
     * @param start The starting space for BFS.
     * @param lift Whether to include lifts in the path.
     * @param enter Whether to allow entry to spaces during the path.
     */
    private void bfs(Map<Space, LinkedList<Space>> graph, Space start, boolean lift, boolean enter) {
        if (start instanceof PublicRoad) {
            return;
        }

        Map<Space, Boolean> discovered = new HashMap<>(); // Tracks discovered nodes.
        Map<Space, Space> predecessor = new HashMap<>(); // Tracks path predecessors.
        Queue<Space> queue = new LinkedList<>(); // BFS queue.

        discovered.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            Space current = queue.poll();

            if (current instanceof PublicRoad) {
                reconstructPath(predecessor, start, current, enter);
                return;
            }

            for (Space neighbor : graph.getOrDefault(current, new LinkedList<>())) {
                if (!discovered.getOrDefault(neighbor, false) && (lift || !(neighbor instanceof Lift))) {
                    discovered.put(neighbor, true);
                    predecessor.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * Reconstructs the path from the starting space to the target space.
     *
     * PRE: The predecessor map must be valid and contain a path to the target space.
     * POST: Updates the `path` field with the reconstructed path.
     *
     * @param predecessor A map of predecessors for path reconstruction.
     * @param start The starting space.
     * @param target The target space.
     * @param enter Whether to allow entry to spaces in the path.
     */
    private void reconstructPath(Map<Space, Space> predecessor, Space start, Space target, boolean enter) {
        for (Space at = target; at != start; at = predecessor.get(at)) {
            path.add(at);
        }
        if (!enter) {
            path = path.reversed();
        }
    }
}
