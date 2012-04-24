import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class TracingBeforeAdvice implements MethodBeforeAdvice
{
   public void before(Method m, Object[] args, Object target) throws Throwable
   {
	  System.out.println("Metodo: "+m.getName());
	  if (args != null) {
		StringBuffer string = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
			Object o = args[i];
			string.append(o);
		}
		System.out.println("Argumentos: " + string);
	}
   }
}