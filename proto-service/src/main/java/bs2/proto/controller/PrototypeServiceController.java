package bs2.proto.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bs2.proto.model.License;

@RestController
@RequestMapping(value = "v1/altron/prototype/{organizationId}/licenses")
public class PrototypeServiceController {

    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {

        return new License().withId(licenseId).withOrganizationId(organizationId).withProductName("Teleco")
                .withLicenseType("Seat");
    }
}
