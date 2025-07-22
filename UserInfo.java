public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean IsActive;

    public void setName (String newName){
        name= newName;
    }

    public void setAge (int newAge){
        age= newAge;
    }

    public void setEmail(String newEmail){
        email=newEmail;

    }

    public void setIsActive(boolean newActive){
        IsActive=newActive;

    }

    public String getInfo(){
        return "Name: " + name +"\nAge: " + age +"\nEmail: " +email+ "\nIsActive: "+ IsActive;

    }
    public static class Main{
        public static void main(String[] args){
            UserInfo N1= new UserInfo();
            N1.setName("Alzahra");
            N1.setAge(22);
            N1.setEmail("Alzahraamur11@gmail.com");
            N1.setIsActive (true);
            System.out.println(N1.getInfo());

            UserInfo N2= new UserInfo();
            N2.setName("Noor");
            N2.setAge(30);
            N2.setEmail("noor22@gmail.com");
            N2.setIsActive(true);
            System.out.println(N2.getInfo());

            UserInfo N3= new UserInfo();
            N3.setName("Malak");
            N3.setAge(27);
            N3.setEmail("Malak@gmail.com");
            N3.setIsActive(false);
            System.out.println(N3.getInfo());
        }
    }
    }

