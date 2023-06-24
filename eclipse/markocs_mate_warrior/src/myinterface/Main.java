package myinterface;

public class Main {
    public static void main(String[] args) {
        People<People> p1= new People<People>( 24,"Markocs Mate");


        System.out.println(p1.getBirthDate());
        People pg=p1.get();
        System.out.println(p1.get());
    }
}
