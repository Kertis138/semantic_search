package univek.com.semanticserver.server.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import univek.com.semanticserver.server.responses.ServerResponse;
import univek.com.semanticserver.server.responses.impl.RequestCountStatusControllerResponse;
import univek.com.semanticserver.server.responses.impl.StatusControllerResponse;

import java.util.concurrent.ThreadLocalRandom;

@Component
@RequestMapping("status")
public class StatusController extends AbstractRestController {

    @Autowired
    public StatusController() {
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ServerResponse index() {
        StatusControllerResponse response = new StatusControllerResponse();
        return response.getWithStatus("1");
    }

    @RequestMapping(value = "myRequestCount", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ServerResponse _requestCount() {
        RequestCountStatusControllerResponse response = new RequestCountStatusControllerResponse();
        int[] testData = {15,13,15,15,20,10,15,16,15,17};

        for (int i = 0; i < 10; i++) {
            //response.requestCount[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            response.requestCount[i] = testData[i];
        }
        return response.getWithStatus("1");
    }

    @RequestMapping(value = "allRequestCount", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ServerResponse requestCount() {
        RequestCountStatusControllerResponse response = new RequestCountStatusControllerResponse();
        int[] testData = {10,50,40,60,60,60,75,60,60,60};
        for (int i = 0; i < 10; i++) {
            //response.requestCount[i] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            response.requestCount[i] = testData[i];
        }
        return response.getWithStatus("1");
    }
}
