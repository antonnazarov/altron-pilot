package altron.test.synch.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("server-side")
public interface ServiceProvider {

    @RequestMapping(value = "altron/server", params = { "msg" }, method = RequestMethod.GET)
    String handle(@RequestParam("msg") String msg);
}
