package altron.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import altron.producer.events.source.QueuePublisher;

@RestController
@RequestMapping(value = "altron/producer")
public class ProducerServiceController {
    
    @Autowired
    QueuePublisher publisher;

    @RequestMapping(value = "/{firstName}/{secondName}", method = RequestMethod.GET)
    public String getLicenses(@PathVariable("firstName") String firstName,
            @PathVariable("secondName") String secondName) {

        java.util.Date timestamp = new java.util.Date();
        publisher.publish(firstName, secondName, timestamp);
        
        return "Service has received the following request: firstName=[" + firstName + "], secondName=[" + secondName + "], called at=["
                + timestamp + "]";
    }
}
