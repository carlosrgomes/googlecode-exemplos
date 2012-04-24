
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApplication
{
   public static void main(String [] args)
   {
      // Read the configuration file
      ApplicationContext ctx
          = new FileSystemXmlApplicationContext("build/springconfig.xml");

      //Instantiate an object
      IBusinessLogic testObject = (IBusinessLogic) ctx.getBean("businesslogicbean");

      //Execute the public methods of the bean
      testObject.foo();
      
      try
      {
         testObject.bar("sei la");
      }
      catch(BusinessLogicException ble)
      {
         System.out.println("Caught BusinessLogicException");
      }
   }
}
