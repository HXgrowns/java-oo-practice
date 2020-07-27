package com.twu.utils;

public enum Tips {
    ASK_USER_NAME("请输入你的名字"),
    ASK_USER_TYPE("欢迎来到热搜排行榜，你是？"),
    WARNING_INPUT("输入格式有误"),
    QUIT("退出系统"),
    ADD_SUCCESS("添加成功"),
    ADD_FAIL("添加失败，已存在"),
    ADD_TIPS("请输入热搜事件的名字"),
    VOTE_HOT_SEARCH_TIPS("请输入你要投票的热搜事件"),
    FIND_HOT_SEARCH_FAIL("没有找到你要投票的热搜"),
    VOTE_COUNT_TIPS("请输入票数,最多可投 = "),
    OUT_VOTE_COUNT_TIPS("票数不足，请重新投票"),
    BUY_HOT_SEARCH_DESC("请输入你要购买的热搜事件"),
    BUY_HOT_SEARCH_RANK("请输入你要购买的排名"),
    OUT_RANK_TIPS("超出现有排名范围"),
    BUY_HOT_SEARCH_MONEY("请输入你要购买的金额"),
    BUY_SUCCESS("购买成功"),
    LOWER_RANK_HOT_SEARCH_MONEY("低于该排名热搜购买金额");

    private String description;

    Tips(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
