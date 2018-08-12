package de.heikostumpf.aws.ec2instanceinfo.controllers;

import de.heikostumpf.aws.ec2instanceinfo.models.EC2InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EC2InstanceInfoController {

    @Autowired
    private EC2InstanceInfo ec2InstanceInfo;

    @RequestMapping(value = "/ec2instanceinfo", method = RequestMethod.GET, produces = "application/json")
    public EC2InstanceInfo getEC2InstanceInfo() {

        return ec2InstanceInfo;
    }

}
