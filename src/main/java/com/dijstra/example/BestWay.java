package com.dijstra.example;
import java.util.Arrays;

public class BestWay implements Algorithm{

    private BestWay(){}
    static void dijstra(City[][] map, int source, int dest){
        boolean[] visitedVertex = new boolean[map.length];
        int[] distance = new int[map.length];
        int[] path = new int[map.length];//esto es para almacenar la ruta
        Arrays.fill(path,0);
        path[source] = -1; // se inicializa a el vertex con -1

        Arrays.fill(visitedVertex, false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < map.length; i++) {
            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true; // se actualiza

            // Update all the neighbouring vertex distances
            for (int v = 0; v < map.length; v++) {
                if (!visitedVertex[v] && map[u][v].getCost() != 0 && (distance[u] + map[u][v].getCost() < distance[v])) {
                    distance[v] = distance[u] + map[u][v].getCost(); //costo / distancia total
                    path[v] = u; // ruta
                }
            }
        }

        System.out.print(String.format("Distancia desde %s hacia %s es %s km. Ruta estimada: ", map[0][source].getName() , map[0][dest].getName(), distance[dest]));
        getRoute(path,dest, map);

    }

    private static void getRoute(int[] prev, int i, City[][] map)
    {
        if (i >= 0)
        {
            getRoute(prev, prev[i],  map);
            System.out.print("->" + map[0][i].getName() + " ");

        }
    }

    static int findMinDistance(int[] distance, boolean[] visited){
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}
