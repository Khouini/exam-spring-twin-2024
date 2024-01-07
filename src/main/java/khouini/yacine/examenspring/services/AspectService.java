package khouini.yacine.examenspring.services;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {
    private static final Logger log = LoggerFactory.getLogger(AspectService.class);
     /*@Pointcut("execution(* khouini.yacine.examenspring.services..get*(..))")
    private void getMethods() {}*/

    //@After("getMethods()")
    @AfterReturning("execution(* khouini.yacine.examenspring.services..addVehicleResaAndAffectToXassingService*(..))")
    public void afterGet(){
        log.info("Waiting for a worker");
    }
}
