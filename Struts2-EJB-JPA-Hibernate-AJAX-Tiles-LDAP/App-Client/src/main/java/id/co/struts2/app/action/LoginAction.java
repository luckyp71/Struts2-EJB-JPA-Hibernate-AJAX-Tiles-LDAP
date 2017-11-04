package id.co.struts2.app.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware{
    
    private String username;
    private String password;
    private Map <String, Object> session;
    
    @Override
    public String execute(){
        
        if(!username.equals("") && !password.equals("")){
            session.put("username", username);
            return SUCCESS;
        }
        else{
            return ERROR;
        }
    }
    
    public String logout(){
        session.remove("username",username);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
}
