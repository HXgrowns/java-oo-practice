package com.twu.utils;

public enum Operation {
    CHECK_RANK("查看热搜排行榜"),
    ADD_HOT_SEARCH("添加热搜"),
    ADD_SUPER_HOT_SEARCH("添加超级热搜"),
    BUY_HOT_SEARCH("购买热搜"),
    VOTE_HOT_SEARCH("给热搜事件投票");
    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
