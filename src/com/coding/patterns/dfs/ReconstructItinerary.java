package com.coding.patterns.dfs;
import java.util.*;


public class ReconstructItinerary {
    // Priority Queue will hold all to locations in sorted order as requested
    static HashMap<String, PriorityQueue> map = new HashMap<>();
    // Store output
    static List<String> result = new ArrayList<>();

    private static void dfs(String airPort) {
        while (map.containsKey(airPort) && !map.get(airPort).isEmpty()) {
            PriorityQueue<String> toAirports = map.get(airPort);
            String toAirport = toAirports.poll();
            dfs(toAirport);
        }
        result.add(0, airPort);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }

    public static void main(String[] args) {
        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        System.out.println(findItinerary(tickets));
    }
}
