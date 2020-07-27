package com.twu.hotSearch;

public class HotSearch {
    private final String description;
    private int hot;
    private final boolean isSuper;
    private int expense = 0;

    public HotSearch(String description, boolean isSuper) {
        this.description = description;
        this.hot = 0;
        this.isSuper = isSuper;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void print(int rank) {
        System.out.println("排名=" + rank +
                ", 热搜=" + description +
                ", 热度=" + hot);
    }

}
