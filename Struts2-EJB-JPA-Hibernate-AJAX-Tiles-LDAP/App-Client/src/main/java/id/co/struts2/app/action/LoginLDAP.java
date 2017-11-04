package id.co.struts2.app.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class LoginLDAP extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> session;
    private String username;
    private String password;
    
    public Map<String, Object> getSession() {
        return session;
    }
  
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    HttpServletRequest request = ServletActionContext.getRequest();
    Authentication ldapAuth = new Authentication();

    @Override
    public String execute() throws IOException {

        username = request.getParameter("username");
        password = request.getParameter("password");

        boolean isValid = false;
        isValid = ldapAuth.loginLDAP(username, password);

        if ((isValid) && (!password.equals(""))) {
            session.put("username", username);
            return SUCCESS;
        } else {
            addActionError("Please enter valid username and password");
            return ERROR;
        }
    }

}
