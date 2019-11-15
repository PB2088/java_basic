package org.pb.basic.graph;

import org.junit.Test;

/**
 * @author bo.peng
 * @create 2019-11-14 17:28
 */
public class GraphTest {

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
}
