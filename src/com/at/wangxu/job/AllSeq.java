package com.at.wangxu.job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSeq {

    public static void main(String[] args) {
        List<Dragon> dragons = new ArrayList<>(Arrays.asList(new Dragon(1), new Dragon(2), new Dragon(3), new Dragon(4), new Dragon(5)));

        List<Area> areas = new ArrayList<>(Arrays.asList(new Area(6), new Area(7), new Area(8), new Area(9)));
        List<List<Area>> allList = new ArrayList<>();
        dfs(allList, new ArrayList<>(), dragons, areas);

        allList.forEach(lists -> {
            lists.forEach(area -> System.out.print("areaId: " + area.getAreaId() + "; dragonId: " + area.getDragonId()));
            System.out.println();
        });
    }

    public static void dfs(List<List<Area>> lists, List<Area> list, List<Dragon> list1, List<Area> list2) {
        if (list1.size() == 0 || list2.size() == 0) {
            lists.add(new ArrayList<>(list));
            list.clear();
            return;
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                list.add(new Area(list2.get(j).areaId, list1.get(i).dragonId));
                Dragon dragon = list1.get(i);
                Area area = list2.get(j);
                int tempI = i;
                int tempJ = j;
                list1.remove(i);
                list2.remove(j);
                dfs(lists, list, list1, list2);
                list1.add(tempI, dragon);
                list2.add(tempJ, area);
            }
        }

    }

}

class Dragon {
    int dragonId;

    public Dragon(int dragonId) {
        this.dragonId = dragonId;
    }
}

class Area {
    int areaId;
    int dragonId;

    public Area(int areaId) {
        this.areaId = areaId;
    }

    public Area(int areaId, int dragonId) {
        this.areaId = areaId;
        this.dragonId = dragonId;
    }

    public int getDragonId() {
        return dragonId;
    }

    public void setDragonId(int dragonId) {
        this.dragonId = dragonId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
