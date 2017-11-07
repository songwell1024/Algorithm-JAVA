/**
 * This program get the area of rectangle
 * @version 1.0 2017.11.03
 * @author songzhiyong
 */
public class Rectangle {
	//public static double area;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Rectangletest rec = new Rectangletest(3,4);
    //area = rec.getArea();
    System.out.print(rec.getArea());
	}
}
class Rectangletest{
  private double width;
  private double height;
  
  public Rectangletest(double wid,double hei ){
	  this.width = wid;  //this 隐式参数，即所构造的对象
	  this.height = hei;
  }
  public double getArea(){
	  return width*height;
  }
}