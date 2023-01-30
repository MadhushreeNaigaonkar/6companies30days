package Amazon;

import java.util.Random;

class Solution {
    private static final Random random = new Random();
    private double radius, x_center, y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double r = Math.sqrt(random.nextDouble()) * radius, theta = random.nextDouble() * 2 * Math.PI;
        return new double[] { x_center + r * Math.cos(theta), y_center + r * Math.sin(theta) };
    }
}
