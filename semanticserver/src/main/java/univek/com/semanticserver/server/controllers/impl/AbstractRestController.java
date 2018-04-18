package univek.com.semanticserver.server.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import univek.com.semanticserver.server.controllers.Controller;

@RestController("AbstractController")
public abstract class AbstractRestController implements Controller {

    @Autowired
    ApplicationContext context;
}
