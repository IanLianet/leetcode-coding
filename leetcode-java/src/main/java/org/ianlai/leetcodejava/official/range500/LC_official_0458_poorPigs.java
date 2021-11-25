package org.ianlai.leetcodejava.official.range500;

public class LC_official_0458_poorPigs {
    public static void main(String[] args) {

    }



    /*
     * 我们一共可以进行n轮实验（n = minutesToTest / minutesToDie）：
     * 经过所有实验，一只小猪能有多少种状态？第一轮就死、第二轮死、...、第n轮死，以及生还，所以一共有n + 1种状态
     * n + 1种状态所携带的信息为log_2(n + 1)比特，这也是一只小猪最多提供的信息量
     * 而”buckets瓶液体中哪一瓶是毒“这件事，也有buckets种可能性，所以需要的信息量是log_2(buckets)
     * 注：以上所有事件、状态都是先验等概的，所以可以直接对2取对数得到信息熵
     *
     * 因此一定存在一种“合理设计”的实验，使得我们只要有k只猪猪：
     * 满足 k * log_2(n + 1) >= log_2(buckets)时，则我们一定能得到足够的信息量去判断哪一瓶是毒。
     * 即 k >= log_(n+1)(buckets) 换底公式
     * 因为java只有Math.log(),以e为底，故用换底公式 k = Math.ceil(Math.log(buckets)/Math.log(n+1))
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        return (int) Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie+1));
    }
}

