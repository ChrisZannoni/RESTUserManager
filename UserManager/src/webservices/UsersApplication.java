package webservices;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//TODO: Find out why I still need  <context-param> in web.xml
@ApplicationPath("api")
public class UsersApplication extends Application {

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(UsersResource.class);
        return s;
	}
}
