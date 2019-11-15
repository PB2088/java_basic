package org.pb.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图
 * @author bo.peng
 * @create 2019-11-14 16:38
 */
public class Graph {
    /** 顶点列表 */
    private List<String> vertexs;

    /** 邻结矩阵 */
    private int[][] edges;

    /** 表示边的数目 */
    private int numOfEdge;

    /** 默认大小 */
    public static final int DEFAULT_SIZE = 20;

    public Graph(int size) {
        int workSize = size < 0 ? DEFAULT_SIZE : size;

        edges = new int[workSize][workSize];
        vertexs = new ArrayList<>(workSize);
    }

    public void addVertex(String vertex) {
        vertexs.add(vertex);
    }

    /**
     * 增加一条边
     * @param start 边的起始位置
     * @param end 边的结束位置
     * @param weight 边的权重
     */
    public void addEdge(int start,int end,int weight) {
        edges[start][end] = weight;
        edges[end][start] = weight;

        numOfEdge ++;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

}
