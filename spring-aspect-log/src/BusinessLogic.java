
public class BusinessLogic implements IBusinessLogic
{
     public void foo() 
     {
       System.out.println("Dentro do Metodo foo");
     }
     
     public void bar(String arg) throws BusinessLogicException
     {
        System.out.println("Dentro do metodo bar");
        throw new BusinessLogicException();
     }
}
