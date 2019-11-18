package org.pb.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    private boolean[] visiteds;

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

    public String getValueByIndex(int index) {
        return vertexs.get(index);
    }


    /**
     * 深度优先遍历
     * @param index
     */
    private void dfs(int index) {
        /** 首先访问节点,输出 */
        System.out.print(getValueByIndex(index) + "->");
        /** 将节点设置为已访问 */
        visiteds[index] = Boolean.TRUE;
        /** 查找第一个邻接节点 */
        int w = getFirstNeighbor(index);

        while (w != -1) {
            if (!isVisited(w)) {
                dfs(w);
            }
            w = getNextNeighbor(index,w);
        }
    }

    /**
     * 深度优先遍历所有节点
     */
    public void dfs() {
        visiteds = new boolean[vertexs.size()];
        for (int i = 0; i < vertexs.size(); i++) {
            if (!visiteds[i]) {
                dfs(i);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {
        visiteds = new boolean[vertexs.size()];
        for (int i = 0; i < vertexs.size(); i++) {
            if (!visiteds[i]) {
                bfs(i);
            }
        }
    }

    /**
     * 广度优先遍历
     * @param index
     */
    private void bfs(int index) {
        /** 首先访问节点,输出 */
        System.out.print(getValueByIndex(index) + "->");
        /** 将节点设置为已访问 */
        visiteds[index] = Boolean.TRUE;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            Integer u = queue.removeFirst();
            int w = getFirstNeighbor(u);
            while (w != -1) {
                if (!visiteds[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    visiteds[w]  = Boolean.TRUE;
                    queue.add(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    private boolean isVisited(int index) {
        return visiteds[index];
    }

    /**
     * 获取第一个邻接节点的下标
     * @param index
     * @return 如果存在就返回对应的下标,否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexs.size(); i++) {
            if (edges[index][i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v1
     * @param v2
     * @return 如果存在就返回对应的下标,否则返回-1
     */
    public int getNextNeighbor(int v1,int v2) {
        for (int i = v2 + 1; i < vertexs.size(); i++) {
            if (edges[v1][i] != 0) {
                return i;
            }
        }
        return -1;
    }

}
