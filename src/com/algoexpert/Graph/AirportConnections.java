package com.algoexpert.Graph;

import java.util.*;

/**
 * AlgoExpert Problem: https://www.algoexpert.io/questions/Airport%20Connections
 * Category: Very Hard
 */
class AirportNode {
    String airport;
    List<String> connections;
    boolean isReachable;
    List<String> unreachableConnections;

    public AirportNode(String airport) {
        this.airport = airport;
        connections = new ArrayList<>();
        isReachable = true;
        unreachableConnections = new ArrayList<>();
    }
}
public class AirportConnections {
    // Time Complexity: O(A + R), where A is size of airports & R is size of routes
    // Space Complexity: O(A + R), where A is size of airports & R is size of routes
    private static Map<String, AirportNode> createAirportGraph(List<String> airports, List<List<String>> routes) {
        Map<String, AirportNode> graph = new HashMap<>();
        for(String airport: airports) {
            graph.put(airport, new AirportNode(airport));
        }
        for(List<String> route: routes) {
            String airportFrom = route.get(0);
            String airportTo = route.get(1);
            graph.get(airportFrom).connections.add(airportTo);
        }
        return graph;
    }
    private static void dfs(Map<String, AirportNode> airportGraph, String airport, Set<String> visited) {
        if (visited.contains(airport)) return;
        visited.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for(String connection: connections) {
            dfs(airportGraph, connection, visited);
        }
    }
    // Time Complexity: O(A + R), where A is size of airports & R is size of routes
    // Space Complexity: O(A), where A is size of airports & R is size of routes
    private static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph, List<String> airports,
                                                                String startingAirport) {
        Set<String> visited = new HashSet<>();
        dfs(airportGraph, startingAirport, visited);

        List<AirportNode> unreachableNodes = new ArrayList<>();
        for(String airport: airports) {
            if (visited.contains(airport)) continue;
            AirportNode airportNode = airportGraph.get(airport);
            airportNode.isReachable = false;
            unreachableNodes.add(airportNode);
        }
        return unreachableNodes;
    }

    private static void dfsUnReachable(Map<String, AirportNode> airportGraph, String airport, Set<String> visited,
                                       List<String> unreachableConnections) {
        if (airportGraph.get(airport).isReachable) return;
        if (visited.contains(airport)) return;
        visited.add(airport);
        unreachableConnections.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection: connections) {
            dfsUnReachable(airportGraph, connection, visited, unreachableConnections);
        }
    }

    // Time Complexity: O(A * (A + R)), where A is size of airports & R is size of routes
    // Space Complexity: O(A), where A is size of airports & R is size of routes
    private static void markUnreachableConnections(Map<String, AirportNode> airportGraph,
                                                   List<AirportNode> unreachableAirportNodes) {
        for (AirportNode unreachableAirportNode: unreachableAirportNodes) {
            Set<String> visited = new HashSet<>();
            String airport = unreachableAirportNode.airport;
            List<String> unreachableConnections = new ArrayList<>();
            dfsUnReachable(airportGraph, airport, visited, unreachableConnections);
            unreachableAirportNode.unreachableConnections = unreachableConnections;
        }
    }

    // Time Complexity: O(Alog(A) + (A + R)), where A is size of airports & R is size of routes
    // Space Complexity: O(1), where A is size of airports & R is size of routes
    private static int getMinNumberOfNewConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        unreachableAirportNodes.sort((a1, a2) -> a2.unreachableConnections.size() - a1.unreachableConnections.size());
        int numberOfMinNewConnections = 0;
        for(AirportNode unreachableNode: unreachableAirportNodes) {
            if (unreachableNode.isReachable) continue;
            numberOfMinNewConnections++;
            for(String connection: unreachableNode.unreachableConnections) {
                airportGraph.get(connection).isReachable = true;
            }
        }
        return numberOfMinNewConnections;
    }

    public static int airportConnections(List<String> airports, List<List<String>> routes,
                                         String startingAirport) {
        // Step - 1 Create a Graph
        Map<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
        // Step - 2 find all unreachable airports
        List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph, airports, startingAirport);
        // Step - 3 Assign scores
        markUnreachableConnections(airportGraph, unreachableAirportNodes);
        // Step - 4
        return getMinNumberOfNewConnections(airportGraph, unreachableAirportNodes);
    }

    public static void main(String[] args) {
        List<String> airports = new ArrayList<String>();
        airports.add("BGI");
        airports.add("CDG");
        airports.add("DEL");
        airports.add("DOH");
        airports.add("DSM");
        airports.add("EWR");
        airports.add("EYW");
        airports.add("HND");
        airports.add("ICN");
        airports.add("JFK");
        airports.add("LGA");
        airports.add("LHR");
        airports.add("ORD");
        airports.add("SAN");
        airports.add("SFO");
        airports.add("SIN");
        airports.add("TLV");
        airports.add("BUD");

        List<List<String>> routes = new ArrayList<>();
        List<String> route1 = new ArrayList<>();
        route1.add("DSM");
        route1.add("ORD");

        List<String> route2 = new ArrayList<>();
        route2.add("ORD");
        route2.add("BGI");

        List<String> route3 = new ArrayList<>();
        route3.add("BGI");
        route3.add("LGA");

        List<String> route4 = new ArrayList<>();
        route4.add("SIN");
        route4.add("CDG");

        List<String> route5 = new ArrayList<>();
        route5.add("CDG");
        route5.add("SIN");

        List<String> route6 = new ArrayList<>();
        route6.add("CDG");
        route6.add("BUD");

        List<String> route7 = new ArrayList<>();
        route7.add("DEL");
        route7.add("DOH");

        List<String> route8 = new ArrayList<>();
        route8.add("DEL");
        route8.add("CDG");

        List<String> route9 = new ArrayList<>();
        route9.add("TLV");
        route9.add("DEL");

        List<String> route10 = new ArrayList<>();
        route10.add("EWR");
        route10.add("HND");

        List<String> route11 = new ArrayList<>();
        route11.add("HND");
        route11.add("ICN");

        List<String> route12 = new ArrayList<>();
        route12.add("HND");
        route12.add("JFK");

        List<String> route13 = new ArrayList<>();
        route13.add("ICN");
        route13.add("JFK");

        List<String> route14 = new ArrayList<>();
        route14.add("JFK");
        route14.add("LGA");

        List<String> route15 = new ArrayList<>();
        route15.add("EYW");
        route15.add("LHR");

        List<String> route16 = new ArrayList<>();
        route16.add("LHR");
        route16.add("SFO");

        List<String> route17 = new ArrayList<>();
        route17.add("SFO");
        route17.add("SAN");

        List<String> route18 = new ArrayList<>();
        route18.add("SFO");
        route18.add("DSM");

        List<String> route19 = new ArrayList<>();
        route19.add("SAN");
        route19.add("EYW");

        routes.add(route1);
        routes.add(route2);
        routes.add(route3);
        routes.add(route4);
        routes.add(route5);
        routes.add(route6);
        routes.add(route7);
        routes.add(route8);
        routes.add(route9);
        routes.add(route10);
        routes.add(route11);
        routes.add(route12);
        routes.add(route13);
        routes.add(route14);
        routes.add(route15);
        routes.add(route16);
        routes.add(route17);
        routes.add(route18);
        routes.add(route19);
        System.out.println(airportConnections(airports, routes, "LGA"));
    }
}
