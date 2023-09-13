package version1;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getDistance(double x1,double y1){
        return Math.hypot(this.x-x1,this.y-y1);
    }
    
    public double getDistance(MyPoint ptr){
        return getDistance(ptr.x,ptr.y);
    }
    
    public double getDistance(){
        return getDistance(0,0);
    }
    

    public void showPoint(){
        System.out.printf("(%.0f,%.0f)",getX(),getY());
    }
    
    public int getQuadrant(){
        if(this.x==0 && this.y==0){
            return 0;
        }else if(this.x > 0 && this.y > 0){
            return 1;
        }else if(this.x<0 && this.y>0){
            return 2;
        }else if(this.x<0 && this.y<0){
            return 3;
        }else if(this.x>0 && this.y<0){
            return 4;
        }else if(this.y==0){
            return 5;
        }else if(this.x==0){
            return 6;
        }
    }
    
    public double getAngle(){
        return Math.toDegrees(Math.atan2(x, y));
    }

    @Override
    public String toString() {
        return String.format("Point: (%.0f,%.0f)",getX(),getY());
    }
    

    
}
