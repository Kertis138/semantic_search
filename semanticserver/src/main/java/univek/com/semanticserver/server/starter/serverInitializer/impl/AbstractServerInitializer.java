package univek.com.semanticserver.server.starter.serverInitializer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import univek.com.semanticserver.server.starter.serverInitializer.ServerInitializer;

public abstract class AbstractServerInitializer implements ServerInitializer {

    @Autowired
    ApplicationContext context;
}
