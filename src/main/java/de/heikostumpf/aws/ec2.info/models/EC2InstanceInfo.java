package de.heikostumpf.aws.ec2.info.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EC2InstanceInfo {

    @Value("${local-ipv4:N/A}")
    private String internalIPAddress;

    @Value("${public-ipv4:N/A}")
    private String externalIPAddress;

    @Value("${instance-id:N/A}")
    private String instanceId;

    public String getInternalIPAddress() {
        return internalIPAddress;
    }

    public void setInternalIPAddress(String internalIPAddress) {
        this.internalIPAddress = internalIPAddress;
    }

    public String getExternalIPAddress() {
        return externalIPAddress;
    }

    public void setExternalIPAddress(String externalIPAddress) {
        this.externalIPAddress = externalIPAddress;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public String toString() {
        return "EC2InstanceInfo{" +
                "internalIPAddress='" + internalIPAddress + '\'' +
                ", externalIPAddress='" + externalIPAddress + '\'' +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
