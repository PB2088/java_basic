package org.pb.basic.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-11-14 17:28
 */
public class GraphTest {

    private  Graph graph;

    @Before
    public void setUp() {
        String[] vertexs = {"A","B","C","D","E"};

        graph = new Graph(vertexs.length);

        for (String vertex : vertexs) {
            graph.addVertex(vertex);
        }

        /** 插入边：A-B,A-C,B-C,B-D,B-E */
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
    }

    @Test
    public void testAddEdge() {
        String[] vertexs = {"A","B","C","D","E"};

        Graph graph = new Graph(vertexs.length);

        for (String vertex : vertexs) {
            graph.addVertex(vertex);
        }

        /** 插入边：A-B,A-C,B-C,B-D,B-E */
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);

        graph.showGraph();
    }

    @Test
    public void testDFS() {
        System.out.println("深度优先遍历:");
        graph.dfs();

        System.out.println();

        System.out.println("广度优先遍历:");
        graph.bfs();
    }

    @Test
    public void testCompared() {
        String[] vertexs = {"1","2","3","4","5","6","7","8"};

        graph = new Graph(vertexs.length);

        for (String vertex : vertexs) {
            graph.addVertex(vertex);
        }

        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(3,7,1);
        graph.addEdge(4,7,1);
        graph.addEdge(2,5,1);
        graph.addEdge(2,6,1);
        graph.addEdge(5,6,1);

        System.out.println("深度优先遍历:");
        graph.dfs();

        System.out.println();

        System.out.println("广度优先遍历:");
        graph.bfs();
    }
}
