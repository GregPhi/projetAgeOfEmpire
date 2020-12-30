package com.example.civilizationlibrairy_aoe2.data.api.object;

/**
 * object representing cost of unit or technology retrieved by the API
 */
public class Cost {
    private int Wood;
    private int Gold;
    private int Food;
    private int Stone;

    public Cost() {
    }

    public int getWood() {
        return Wood;
    }

    public void setWood(int wood) {
        Wood = wood;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int food) {
        Food = food;
    }

    public int getStone() {
        return Stone;
    }

    public void setStone(int stone) {
        Stone = stone;
    }
}
