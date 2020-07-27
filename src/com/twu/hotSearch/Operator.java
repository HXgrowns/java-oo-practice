package com.twu.hotSearch;

public class Operator {
    private static final HotSearchRepository hotSearchRepository = new HotSearchRepository();

    public static void show() {
        hotSearchRepository.show();
    }

    public static void add() {
        hotSearchRepository.add();
    }

    public static void addSuper() {
        hotSearchRepository.addSuper();
    }

    public static int vote(int voteCount) {
        return hotSearchRepository.vote(voteCount);
    }

    public static void buy() {
        hotSearchRepository.buy();
    }
}
