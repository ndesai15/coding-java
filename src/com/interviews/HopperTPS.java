package com.interviews;

import java.util.*;

public class HopperTPS {
    private static HashMap<String , List<String>> allRoutes(List<String> routes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String route: routes) {
            String[] places = route.split("->");

            if (places.length != 2) {
                return map;
            }

            if(map.containsKey(places[0])) {
                map.get(places[0]).add(places[1]);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(places[1]);
                map.put(places[0], temp);
            }
        }
        return map;
    }
    private static boolean bfs(List<List<String>> result, String source, String dest, List<String> routes,
                            HashMap<String, List<String >> map, String temp2) {
        Queue<String> queue = new LinkedList<>();

        queue.add(source);
        String tempStr = "";
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            List<String> allRoutesFromSource = map.get(current);
            if(!visited.contains(current) &&!allRoutesFromSource.isEmpty()) {
                if(allRoutesFromSource.contains(dest)) {
                    List<String> temp = new ArrayList<>();
                    if (tempStr.isEmpty()) {
                        tempStr = current + "->" + dest;
                        temp.add(tempStr);
                        tempStr = "";
                    }
                    else {
                        tempStr += "->" + dest;
                        temp.add(tempStr);
                    }
                    result.add(temp);
                    allRoutesFromSource.remove(dest);
                    for(String str: allRoutesFromSource) {
                        tempStr += current + "->" + str;
                        queue.add(str);
                    }
                }
                else {
                    for(String str: allRoutesFromSource) {
                        queue.add(str);
                    }
                }
                visited.add(current);
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> findRoutest(String source, String dest, List<String> routes) {
        List<List<String>> result = new ArrayList<>();

        if (source.isEmpty() || dest.isEmpty() || routes.isEmpty()) {
            return result;
        }

        // Create a HM
        HashMap<String, List<String>> map = allRoutes(routes);
        if(bfs(result, source, dest, routes, map, "")){
            return result;
        }
        else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<String> routes = new ArrayList<>();
        routes.add("A->B");
        routes.add("A->C");
        routes.add("B->D");
        routes.add("C->B");
        //routes.add("C->A");
        System.out.println(findRoutest("A", "B",routes));
    }
}
