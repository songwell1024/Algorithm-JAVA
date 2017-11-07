import java.util.*;
/**
 * this program demonstrates object constructor
 * @author songzhiyong
 * @version 1.0 2017.11.04 
 */
public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];  //构造三个Employee对象
		
		staff[0] = new Employee("Harry",30000);
		staff[1] = new Employee(20000);
		staff[2] = new Employee();
		
		for (Employee e :staff){
			System.out.println("name="+e.getname()+",id="+e.getid()+
					",salary="+e.getsalary());
		}
			

	}

}

class Employee{
	private static int nextid;  //静态域属于类，不属于对象，对象不存在时其仍然存在
	
	private int id;
	private String name = "";
	private double salary;
	
	//静态初始化块初始化静态域
	static{
		Random generator = new Random();
		nextid = generator.nextInt(100000);
	}
	
	//无参数构造器
	{
		id = nextid;
		nextid++;
	}
	
	public Employee(String name,double salary){
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(double s){
		//调用Employee(String name,double salary)
		this("Employee #"+nextid, s);
	}
	
	//无参数构造器
	public Employee(){
		
	}
	
	public String getname(){
		return name;
	}
	
	public double getsalary(){
		return salary;
	}
	
	public int getid(){
		return id;
	}
}