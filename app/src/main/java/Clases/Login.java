package Clases;

public class Login {

    //atributos

    private int id_login;
    private String user = "francisco";
    private String pass = "123";

    //Constructores
    public Login() {

        id_login = 3;

    }

    public Login(int id_login, String user, String pass) {
        this.id_login = id_login;
        this.user = user;
        this.pass = pass;
    }

    //Set y get


    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
