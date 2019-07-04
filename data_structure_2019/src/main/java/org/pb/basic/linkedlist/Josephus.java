package org.pb.basic.linkedlist;

/**
 * @author bo.peng
 * @create 2019-06-14 14:37
 */
public class Josephus {
    /**
     * 总人数
     */
    private int total;

    /**
     * 报数的大小
     */
    private int stair;

    /**
     * 开始报数的编号
     */
    private int start;

    private JosephusLinkedList josephus;

    public Josephus(int total, int stair, int start) {
        this.total = total;
        this.stair = stair;
        this.start = start;

        init(total, stair, start);
    }

    private void init(int total, int stair, int start) {
        josephus = new JosephusLinkedList();
        josephus.initJosephusLinkedList(total);
    }

    public void show() {
        josephus.showPeople();
    }

    public void count() {
        josephus.count(start, stair, total);
    }

    private static class JosephusLinkedList {
        private People first;

        public void initJosephusLinkedList(int nums) {
            People current = null;
            for (int i = 1; i <= nums; i++) {
                if (i == 1) {
                    first = new People(i, null);
                    current = first;

                    continue;
                }

                current.next = new People(i, null);
                current.next.next = first;
                current = current.next;
            }
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void showPeople() {
            if (first == null) {
                System.out.println("没有任何小孩~~");
                return;
            }

            People current = first;
            while (true) {
                System.out.printf("小孩的编号: %d \n", current.no);
                if (current.next == first) {
                    break;
                }
                current = current.next;
            }
        }

        public void count(int start, int stair, int total) {
            if (isEmpty() || start < 1 || start > total) {
                System.out.println("参数输入有误， 请重新输入!");
                return;
            }
            // 创建要给辅助指针,帮助完成小孩出圈
            People helper = first;
            //初始化helper指向最后一个节点
            while (true) {
                if (helper.next == first) {
                    break;
                }
                helper = helper.next;
            }

            //报数前,让helper和first移动start-1个位置
            for (int i = 0; i < start - 1; i++) {
                first = first.next;
                helper = helper.next;
            }

            while (true) {
                if (helper == first) {
                    break;
                }

                for (int i = 0; i < stair - 1; i++) {
                    first = first.next;
                    helper = helper.next;
                }

                //这时first指向的节点，就是要出圈的小孩节点
                System.out.printf("小孩%d出圈\n", first.no);
                first = first.next;
                helper.next = first;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.printf("最后留在圈中的小孩编号%d \n", first.no);
        }
    }

    private static class People {
        private int no;
        private People next;

        public People(int no, People next) {
            this.no = no;
            this.next = next;
        }
    }
}
