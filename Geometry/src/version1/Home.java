package version1;

public class Home {
    public static void main(String[] args) {
        MyPoint point=new MyPoint(4, 3);
        double x = point.getDistance(2,3);
        System.out.printf("\n %.2f",x);

        double a = point.getDistance(point);
        System.out.printf("\n %.2f",a);
    }
}
