package univek.com.semanticserver.server.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import univek.com.semanticserver.server.responses.ServerResponse;

@Component
@RequestMapping("auth")
public class AuthController extends AbstractRestController {


    @Autowired
    public AuthController() {
    }

    @RequestMapping(value = "tokenize", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ServerResponse tokenize(@RequestHeader("codeToken") String codeToken) {
        return null;
    }
}
