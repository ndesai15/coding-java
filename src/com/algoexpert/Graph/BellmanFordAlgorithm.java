package com.algoexpert.Graph;

import java.util.*;


/**
 * Bellman-Ford Algorithm : Finding negative cycle
 */
// Time Complexity: O(N^3)
// Space Complexity: O(N^2)
public class BellmanFordAlgorithm {

    private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>>
                                                                    matrix) {
        ArrayList<ArrayList<Double>> newMatrix = new ArrayList<ArrayList<Double>>();
        for (int row = 0; row < matrix.size(); row++) {
            ArrayList<Double> rates = matrix.get(row);
            newMatrix.add(new ArrayList<Double>());
            for (Double rate: rates) {
                newMatrix.get(row).add(-Math.log10(rate));
            }
        }
        return newMatrix;
    }

    private boolean foundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
        double[] distanceFromStart = new double[graph.size()];
        Arrays.fill(distanceFromStart, Double.MAX_VALUE);
        distanceFromStart[start] = 0;

        for (int i = 0; i < graph.size(); i++) {
            // If no update occurs, that means no negative cycle
            if (!relaxEdgesAndUpdateDistances(graph, distanceFromStart)) {
                return false;
            }
        }

        return relaxEdgesAndUpdateDistances(graph, distanceFromStart);
    }

    // Returns true if any distance was updated
    private boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> graph,
                                                 double[] distances) {
        boolean updated = false;
        for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) {
            ArrayList<Double> edges = graph.get(sourceIdx);
            for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
                double edgeWeight = edges.get(destinationIdx);
                double newDistanceToDestination = distances[sourceIdx] + edgeWeight;
                if (newDistanceToDestination < distances[destinationIdx]) {
                    distances[destinationIdx] = newDistanceToDestination;
                    updated = true;
                }
            }
        }
        return updated;
    }

    public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        // To use exchange rates as edge weights, we must be able to convert them.
        // -log10(exchangeRate) to use them as edge weights.
        ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
        return foundNegativeWeightCycle(logExchangeRates, 0);
    }
}
