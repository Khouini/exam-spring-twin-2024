package khouini.yacine.examenspring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppService implements IAppService {
    @Override
    public String test() {
        return "Hello from exam spring";
    }
}
