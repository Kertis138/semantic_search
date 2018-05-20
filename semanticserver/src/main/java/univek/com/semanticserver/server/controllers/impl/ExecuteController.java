package univek.com.semanticserver.server.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import univek.com.semanticserver.core.managers.ScriptManager;
import univek.com.semanticserver.core.scripts.ScriptHandler;
import univek.com.semanticserver.database.domains.Driver;
import univek.com.semanticserver.database.services.DriverService;
import univek.com.semanticserver.server.responses.ServerResponse;
import univek.com.semanticserver.server.responses.impl.ExecutorRunResponse;

@Component
@RequestMapping("execute")
public class ExecuteController extends AbstractRestController {

    private final DriverService driverService;

    @Autowired
    public ExecuteController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "script", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ServerResponse script(@RequestParam("driver_id") Integer driverId) {
        ExecutorRunResponse response = new ExecutorRunResponse();

        Driver driver = driverService.getById(driverId);
        if (driver == null)
            return response.getWithStatus("0");

        try {
//            String script = HtmlUtils.htmlUnescape(driver.getText());
//            ScriptManager scriptManager = new ScriptManager();
//            ScriptHandler scriptHandler = scriptManager.getScriptModel(script);
//            scriptHandler.start();
        }
        catch (Exception e) {
            return response.getWithStatus("0");
        }
        return response.getWithStatus("1");
    }
}
