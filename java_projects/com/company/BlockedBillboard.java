package com.company;

import java.util.Scanner;

public class BlockedBillboard {
    public static int intersectionArea(Billboard b1, Billboard b2) {
        int xOverlap = Math.max(0, Math.min(b1.x2, b2.x2) - Math.max(b1.x1, b2.x1));
        int yOverlap = Math.max(0, Math.min(b1.y2, b2.y2) - Math.max(b1.y1, b2.y1));
        return xOverlap * yOverlap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Billboard b1 = new Billboard(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        Billboard b2 = new Billboard(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        Billboard b3 = new Billboard(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        int totalArea = b1.area() + b2.area() - intersectionArea(b1, b2); // Correct total area

        int intersection13 = intersectionArea(b1, b3);
        int intersection23 = intersectionArea(b2, b3);

        // Calculate intersection of all three billboards
        int intersection123 = intersectionArea(intersectionBillboard(b1,b2),b3);

        int uncoveredArea = totalArea - intersection13 - intersection23 + intersection123; // Correct uncovered area

        System.out.println(uncoveredArea);
        scanner.close();
    }

    public static Billboard intersectionBillboard(Billboard b1, Billboard b2){
        int x1 = Math.max(b1.x1, b2.x1);
        int y1 = Math.max(b1.y1, b2.y1);
        int x2 = Math.min(b1.x2, b2.x2);
        int y2 = Math.min(b1.y2, b2.y2);
        return new Billboard(x1,y1,x2,y2);

    }
}
