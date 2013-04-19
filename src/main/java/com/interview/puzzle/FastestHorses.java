package com.interview.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzh
 *         <B>Question</B>
 *         <P>Let’s say that you have 25 horses, and you want to pick the fastest 3 horses out of those 25. In each race,
 *         only 5 horses can run at the same time because there are only 5 tracks.
 *         What is the minimum number of races required to find the 3 fastest horses without using a stopwatch?
 *         </P>
 */
public class FastestHorses {

    /**
     * Find the fastest horses from raw list
     *
     * @param raw        the input horses
     * @param trackCount how many horses can run at the same time
     * @param topCount   fastest count, ex 3
     * @return the fastest horses
     */
    public static int findFastest(final List<Horse> raw, int trackCount, int topCount) {
        ArrayList<Horse> fastest = new ArrayList<>();
        int raceCount = 0;
        for (int i = 0; i < raw.size() / trackCount; i++ ) {

        }


        return raceCount;
    }

    /**
     * The bigger factor means the A horse is faster then B horse
     * But, you cannot compare it by their speed directly
     */
    public static class Horse implements Comparable<Horse> {
        private String name;

        public Horse(String name, int speed) {
            this.name = name;
            this.speed = new Speed(speed);
        }

        public String getName() {

            return name;
        }

        private Speed speed;

        public int getFactor() {
            return factor;
        }

        public void setFactor(int factor) {
            this.factor = factor;
        }

        private int factor;

        @Override
        public int compareTo(Horse right) {
            return factor - right.getFactor();
        }
    }

    /**
     * You don't have a stopwatch which means you cannot get the speed number directly
     */
    public static class Speed implements Comparable<Speed> {
        private int speed;

        public int getSpeed() {
            return speed;
        }

        public Speed(int speed) {

            this.speed = speed;
        }

        @Override
        public int compareTo(Speed o) {
            return speed - o.getSpeed();
        }
    }
}
