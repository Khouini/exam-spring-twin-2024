package khouini.yacine.examenspring.services;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {
     /*@Pointcut("execution(* khouini.yacine.examenspring.services..get*(..))")
    private void getMethods() {}*/

    //@After("getMethods()")
    @After("execution(* khouini.yacine.examenspring.services..get*(..))")
    public void afterGet(){
        System.out.println("Bon courage");
    }
}
