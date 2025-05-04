package com.company;

import java.util.Scanner;

class Billboard {
    int x1, y1, x2, y2;

    public Billboard(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int area() {
        return (x2 - x1) * (y2 - y1);
    }
}

