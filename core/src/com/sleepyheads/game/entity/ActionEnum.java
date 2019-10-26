package com.sleepyheads.game.entity;

public enum ActionEnum {
    ATTACK(0), MOVE(1), Q(2), E(3), R(4), F(5);
    public final int value;

    /**
     * Set the fixed value for the Enum.
     * @param value
     */
    private ActionEnum(int  value) {
        this.value = value;
    }
}
