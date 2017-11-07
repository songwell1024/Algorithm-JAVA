import java.util.*;
/**
 * this program demonstrates object constructor
 * @author songzhiyong
 * @version 1.0 2017.11.04 
 */
public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];  //��������Employee����
		
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
	private static int nextid;  //��̬�������࣬�����ڶ��󣬶��󲻴���ʱ����Ȼ����
	
	private int id;
	private String name = "";
	private double salary;
	
	//��̬��ʼ�����ʼ����̬��
	static{
		Random generator = new Random();
		nextid = generator.nextInt(100000);
	}
	
	//�޲���������
	{
		id = nextid;
		nextid++;
	}
	
	public Employee(String name,double salary){
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(double s){
		//����Employee(String name,double salary)
		this("Employee #"+nextid, s);
	}
	
	//�޲���������
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