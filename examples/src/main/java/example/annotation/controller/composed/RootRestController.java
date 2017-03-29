package example.annotation.controller.composed;

import example.annotation.controller.composed.link.Destination;
import example.annotation.controller.composed.link.MyLink;
import example.annotation.controller.composed.link.MyLinkDestination;
import example.annotation.controller.composed.link.MyLinks;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootRestController {

    @RequestMapping("/")
    @MyLinks({
            @MyLink(destination = Destination.RESOURCE, templated = true)
    })
    public ResourceSupport root() {
        return new ResourceSupport();
    }

    @RequestMapping("/resource")
    @MyLinkDestination(destination = Destination.RESOURCE)
    public void resource(Pageable pageable) {

    }

}

