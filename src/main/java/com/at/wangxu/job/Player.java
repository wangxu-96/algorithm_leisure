package com.at.wangxu.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Comparable<Player> {

    private long serverId;

    private long playerId;

    private long amount;


    @Override
    public int compareTo(@NotNull Player o) {
        return (int) (o.getAmount() - getAmount());
    }
}
