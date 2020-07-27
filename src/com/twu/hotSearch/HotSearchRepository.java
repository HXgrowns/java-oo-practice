package com.twu.hotSearch;

import com.twu.utils.Tips;

import java.util.*;

public class HotSearchRepository {
    private final Scanner scanner = new Scanner(System.in);
    private final List<HotSearch> hotSearches = new ArrayList<>();

    public void show() {
        hotSearches.sort((hotSearch1, hotSearch2) -> {
            if (hotSearch1.getExpense() > 0 || hotSearch2.getExpense() > 0) {
                return 1;
            }
            return hotSearch2.getHot() - hotSearch1.getHot();
        });
        printList();
    }

    private void printList() {
        for (int i = 0; i < hotSearches.size(); i++) {
            hotSearches.get(i).print(i + 1);
        }
    }

    public void add() {
        System.out.println(Tips.ADD_TIPS.getDescription());
        String hotSearchName = scanner.next();
        if (isExist(hotSearchName)) {
            System.out.println(Tips.ADD_FAIL.getDescription());
            return;
        }
        hotSearches.add(new HotSearch(hotSearchName, false));
        System.out.println(Tips.ADD_SUCCESS.getDescription());
    }

    public void addSuper() {
        System.out.println(Tips.ADD_TIPS.getDescription());
        String hotSearchName = scanner.next();
        if (isExist(hotSearchName)) {
            System.out.println(Tips.ADD_FAIL.getDescription());
            return;
        }
        hotSearches.add(new HotSearch(hotSearchName, true));
        System.out.println(Tips.ADD_SUCCESS.getDescription());
    }

    private boolean isExist(String hotSearchName) {
        return hotSearches.stream()
                .anyMatch(hotSearch -> hotSearch.getDescription().equals(hotSearchName));
    }

    public int vote(int totalCount) {
        System.out.println(Tips.VOTE_HOT_SEARCH_TIPS.getDescription());
        HotSearch selectedHotSearch = hotSearches.get(selectedHotSearchIndex());
        if (selectedHotSearch == null) {
            vote(totalCount);
        }
        int count = voteCount(totalCount);

        if (selectedHotSearch != null) {
            if (selectedHotSearch.isSuper()) {
                selectedHotSearch.setHot(selectedHotSearch.getHot() + (count * 2));
            } else {
                selectedHotSearch.setHot(selectedHotSearch.getHot() + count);
            }
            return totalCount - count;
        }
        return totalCount;
    }

    public void buy() {
        System.out.println(Tips.BUY_HOT_SEARCH_DESC.getDescription());
        int buyHotSearchIndex = selectedHotSearchIndex();
        if (buyHotSearchIndex < 0) {
            return;
        }
        int selectedRank = selectedRank();
        HotSearch replacedHotSearch = hotSearches.get(selectedRank);
        int spend = spend(replacedHotSearch.getExpense());

        HotSearch buyHotSearch = hotSearches.get(buyHotSearchIndex);

        swap(selectedRank, buyHotSearchIndex);
        if (replacedHotSearch.getExpense() > 0 && selectedRank != buyHotSearchIndex) {
            hotSearches.remove(buyHotSearchIndex);
        }
        buyHotSearch.setExpense(spend);

        System.out.println(Tips.BUY_SUCCESS.getDescription());
    }

    private void swap(int originIndex, int replaceIndex) {
        HotSearch temp = hotSearches.get(originIndex);
        hotSearches.set(originIndex, hotSearches.get(replaceIndex));
        hotSearches.set(replaceIndex, temp);
    }

    private int selectedHotSearchIndex() {
        String hotSearchName = scanner.next();
        for (int i = 0; i < hotSearches.size(); i++) {
            if (hotSearches.get(i).getDescription().equals(hotSearchName)) {
                return i;
            }
        }
        return -1;
    }

    private int voteCount(int totalCount) {
        System.out.println(Tips.VOTE_COUNT_TIPS.getDescription() + totalCount);
        try {
            int count = scanner.nextInt();
            if (count > totalCount) {
                System.out.println(Tips.OUT_VOTE_COUNT_TIPS.getDescription());
                return voteCount(totalCount);
            }
            return count;
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            return voteCount(totalCount);
        }
    }

    private int selectedRank() {
        System.out.println(Tips.BUY_HOT_SEARCH_RANK.getDescription());
        try {
            int rank = scanner.nextInt();
            if (rank > hotSearches.size() || rank < 1) {
                System.out.println(Tips.OUT_RANK_TIPS.getDescription());
                return selectedRank();
            }
            return rank - 1;
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            return selectedRank();
        }
    }

    private int spend(int replacedHotSearchMoney) {
        System.out.println(Tips.BUY_HOT_SEARCH_MONEY.getDescription());
        try {
            int expense = scanner.nextInt();
            if (expense <= replacedHotSearchMoney) {
                System.out.println(Tips.LOWER_RANK_HOT_SEARCH_MONEY.getDescription());
                return spend(replacedHotSearchMoney);
            }
            return expense;
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            return spend(replacedHotSearchMoney);
        }
    }
}
