package univek.com.semanticserver.server.controllers.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@RequestMapping("test")
public class TestController extends AbstractRestController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}

    @RequestMapping(value = "other", method = RequestMethod.GET)
    public String other() {
        return "other";
    }

}
