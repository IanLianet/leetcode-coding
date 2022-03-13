package org.ianlai.hsbc.codeTest20220312;

import java.util.*;

/**
 * hsbc test1
 *
 * @author IanLai
 * @date 2022-03-12 17:27:40
 */
public class test1 {
    public static int workingWeeks(int[] projC) {
        int answer = 0;
        // Write your code here

        // initializing the PriorityQueue
        Queue<ProjModule> priorityQueue = new PriorityQueue<>(cmp);
        for (int tempIndex = 0; tempIndex < projC.length; tempIndex++) {
            priorityQueue.add(new ProjModule(tempIndex, projC[tempIndex]));
        }

        return loopToGetMaxWeeks(priorityQueue, -1, answer);
    }

    /**
     * use iteration to get the max weeks to work on projects
     *
     * @author IanLai
     * @date 2022-03-12 17:27:40
     */
    public static int loopToGetMaxWeeks(Queue<ProjModule> priorityQueue, int lastProjIndex, int count) {
        ProjModule firstProj = priorityQueue.poll();
        assert firstProj != null;

        // if the project, that has the biggest module numbers, is the project be worked on last week
        if (firstProj.getProjIndex() == lastProjIndex) {
            ProjModule secondProj = priorityQueue.poll();
            assert secondProj != null;

            // if the second biggest-module-numbers project has 0 module left, kill the loop
            if (secondProj.getModuleNum() == 0) {
                return count;
            } else {
                secondProj.setModuleNum(secondProj.getModuleNum() - 1);
                priorityQueue.add(firstProj);
                priorityQueue.add(secondProj);

                count = loopToGetMaxWeeks(priorityQueue, secondProj.getProjIndex(), count + 1);
            }
        } else {
            if (firstProj.getModuleNum() == 0) {
                return count;
            } else {
                firstProj.setModuleNum(firstProj.getModuleNum() - 1);
                priorityQueue.add(firstProj);
                count = loopToGetMaxWeeks(priorityQueue, firstProj.getProjIndex(), count + 1);
            }
        }

        return count;
    }

    /**
     * define the Comparator to make the first element biggest
     *
     * @author IanLai
     * @date 2022-03-12 17:27:40
     */
    static Comparator<ProjModule> cmp = new Comparator<ProjModule>() {
        @Override
        public int compare(ProjModule e1, ProjModule e2) {
            return e2.getModuleNum() - e1.getModuleNum();
        }
    };

    /**
     * define the DataStructure used in code
     *
     * @author IanLai
     * @date 2022-03-12 17:27:40
     */
    public static class ProjModule {

        private int projIndex;
        private int moduleNum;

        // getter and setter
        public int getProjIndex() {
            return projIndex;
        }

        public void setProjIndex(int projIndex) {
            this.projIndex = projIndex;
        }

        public int getModuleNum() {
            return moduleNum;
        }

        public void setModuleNum(int moduleNum) {
            this.moduleNum = moduleNum;
        }

        // constructor
        public ProjModule(int projIndex, int moduleNum) {
            this.moduleNum = moduleNum;
            this.projIndex = projIndex;
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input for projC
        int projC_size = in.nextInt();
        int projC[] = new int[projC_size];
        for (int idx = 0; idx < projC_size; idx++) {
            projC[idx] = in.nextInt();
        }

        int result = workingWeeks(projC);
        System.out.print(result);

    }

}

