package example.builder;

import com.github.osvaldopina.linkbuilder.LinksBuilder;
import com.github.osvaldopina.linkbuilder.LinksBuilderFactory;
import com.github.osvaldopina.linkbuilder.annotation.LinkDestination;
import example.annotation.controller.composed.link.Destination;
import example.annotation.controller.composed.link.MyLinkDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class RootRestController {

    @Autowired
    private LinksBuilderFactory linksBuilderFactory;

    @RequestMapping("/")
    public ResourceSupport root() {

        ResourceSupport resource = new ResourceSupport();

        LinksBuilder linksBuilder = linksBuilderFactory.create(resource);

        linksBuilder.link()
                .when("hasRole('ROLE_USER')")
                .withRel("user")
                .fromControllerCall(RootRestController.class)
                .resource(new PageRequest(1,2,new Sort("prop1", "prop2")));

        linksBuilder.buildAndSetAll();

        return resource;
    }


    @RequestMapping("/resource")
    @MyLinkDestination(destination = Destination.RESOURCE)
    public void resource(Pageable pageable) {

    }

 }

