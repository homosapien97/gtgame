package com.sleepyheads.game.entity;

public enum ActionEnum {
    ATTACK(0), MOVE(1), Q(2), W(3), E(4), R(5);
    public final int value;

    /**
     * Set the fixed value for the Enum.
     * @param value
     */
    private ActionEnum(int  value) {
        this.value = value;
    }
}
