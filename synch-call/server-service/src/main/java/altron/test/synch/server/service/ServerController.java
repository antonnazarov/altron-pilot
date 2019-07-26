package altron.test.synch.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    Logger logger = LoggerFactory.getLogger(ServerController.class);

    @RequestMapping(value = "altron/server", params = { "msg" }, method = RequestMethod.GET)
    public String handle(@RequestParam("msg") String msg) {
        String ret = "The Server Side was called with the following message=[" + msg + "]";
        logger.info(ret);
        return ret;
    }
}
