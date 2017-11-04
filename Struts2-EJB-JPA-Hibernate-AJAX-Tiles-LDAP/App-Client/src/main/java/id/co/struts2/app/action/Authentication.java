package id.co.struts2.app.action;

import java.io.IOException;
import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class Authentication {

    public boolean loginLDAP(String username, String password) throws IOException {

        boolean validlogin = false;

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + ",ou=users,ou=system");
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext authContext = new InitialDirContext(env);
            LdapContext ctx = new InitialLdapContext(env, null);
            System.out.println("Authentication Success!");
            SearchControls searchControls = getSearchControls();
            getUserInfo(username, ctx, searchControls);
            validlogin = true;

        } catch (AuthenticationException ex) {
            System.out.println("Authentication failed: " + ex.toString());
        } catch (NamingException ex) {
            System.out.println("Authentication failed ! Exception: " + ex.toString());
        }
        return validlogin;
    }

    private static SearchControls getSearchControls() {
        SearchControls cons = new SearchControls();
        cons.setSearchScope(SearchControls.SUBTREE_SCOPE);
        String[] attrIDs = {"cn", "sn","displayName"};
        cons.setReturningAttributes(attrIDs);
        return cons;
    }

    private static void getUserInfo(String username, LdapContext ctx, SearchControls searchControls) {
        System.out.println("userName: " + username);
        String baseDN = "ou=users,ou=system";
        try {
            NamingEnumeration<SearchResult> answer = ctx.search(baseDN, "uid=" + username, searchControls);
            if (answer.hasMore()) {
                Attributes attrs = answer.next().getAttributes();
                System.out.println(attrs.get("cn"));
                System.out.println(attrs.get("sn"));
                System.out.println(attrs.get("displayName"));
            } else {
                System.out.println("user not found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
