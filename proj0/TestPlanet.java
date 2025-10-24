public class TestPlanet {
    public static void main(String[] args) {
        System.out.println(checkPairwiseForce());
    }
    
    public static double checkPairwiseForce() {
        Planet p1 = new Planet(0, 1, 2, 3, 4, "jupiter.gif");
        Planet p2 = new Planet(1, 2, 3, 4, 5, "jupiter.gif");

        return p1.calcForceExertedBy(p2);
    }
}