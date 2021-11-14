package Clases;

public class ReglasNegocio {
    public Boolean ValidaLogin(String userLog, String passLog){  // método para validar login

        Login log = new Login();

        String varUser = log.getUser();
        String varpass = log.getPass();

        if(userLog.equals(varUser) && passLog.equals(varpass)){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
}
