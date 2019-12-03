package org.pb.basic.algorithm;

import cn.hutool.core.collection.CollectionUtil;
import org.pb.util.ToolsUtils;

import java.util.*;

/**
 * 贪心算法
 *
 * @author bo.peng
 * @create 2019-12-03 11:24
 */
public class GreedyAlgorithm {
    public static Map<String, Set<String>> BROADCAST = new HashMap<>();
    public static Set<String> ALL_AREAS = new HashSet<>();

    /**
     * 假设存在如下表的需要付费的广播电台,以及广播电台信号可以覆盖的地区。如果选择最少的广播电台,让所有的地区都可以接收到信号
     *
     *广播电台			覆盖地区
     * 	K1			    "北京","上海","天津"
     * 	K2			    "广州","北京","深圳"
     * 	K3			    "成都","上海","杭州"
     * 	K4			    "上海","天津"
     * 	K5			    "杭州","大连"
     */
    public static void greedy() {
        /* 用于存放已选择的地区 */
        List<String> selects = new ArrayList<>();

        Set<String> tempSet = new HashSet<>();
        while (CollectionUtil.isNotEmpty(ALL_AREAS)) {
            String maxKey = null;
            for (String key : BROADCAST.keySet()) {
                tempSet.clear();
                tempSet.addAll(BROADCAST.get(key));
                tempSet.retainAll(ALL_AREAS);

                final boolean isMaxKey = CollectionUtil.isNotEmpty(tempSet) && (Objects.isNull(maxKey) || tempSet.size() > BROADCAST.get(maxKey).size());
                if (isMaxKey) {
                    maxKey = key;
                }
            }

            if (Objects.nonNull(maxKey)) {
                selects.add(maxKey);
                ALL_AREAS.removeAll(BROADCAST.get(maxKey));
            }
        }

        System.out.printf("得到的选择结果是%s",selects);
    }

    public static void main(String[] args) {
        greedy();
    }

    static {
        Set<String> k1_areas = new HashSet<>();
        k1_areas.addAll(Arrays.asList("北京","上海","天津"));
        BROADCAST.put("K1",k1_areas);
        ALL_AREAS.addAll(k1_areas);

        Set<String> k2_areas = new HashSet<>();
        k2_areas.addAll(Arrays.asList("广州","北京","深圳"));
        BROADCAST.put("K2",k2_areas);
        ALL_AREAS.addAll(k2_areas);

        Set<String> k3_areas = new HashSet<>();
        k3_areas.addAll(Arrays.asList("成都","上海","杭州"));
        BROADCAST.put("K3",k3_areas);
        ALL_AREAS.addAll(k3_areas);

        Set<String> k4_areas = new HashSet<>();
        k4_areas.addAll(Arrays.asList("上海","天津"));
        BROADCAST.put("K4",k4_areas);
        ALL_AREAS.addAll(k4_areas);

        Set<String> k5_areas = new HashSet<>();
        k5_areas.addAll(Arrays.asList("杭州","大连"));
        BROADCAST.put("K5",k5_areas);
        ALL_AREAS.addAll(k5_areas);
    }
}
