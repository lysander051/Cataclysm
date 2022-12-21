package com.cataclysm.partie;

public abstract class  Composant {
    private int x;
    private int y;

    public Composant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
