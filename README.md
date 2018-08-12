# AWS EC2 Instance Information

SpringBoot application to get EC2 metadata like instance-id, public and private ip-address. 
The application was developed to test the different load balancers on AWS.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development. 
See deployment for notes on how to deploy the project on an AWS EC2 instance.

### Prerequisites

You need to have Java (at least Version 1.8), Maven and Git installed on your local development environment 
in order to compile and run the application.

### Installing

Use the spring-boot specific maven plugin the compile and run the application.

```
$ mvn spring-boot:run
```

or


```
$ mvn clean package
java -jar target/ec2instanceinfo-0.0.1-SNAPSHOT.war
```

Once the application is compiled and running call the REST endpoint with the following URL:
```
http://localhost:8080/ec2instanceinfo
```

As the EC2 metadata is only available within the AWS environment the result must be a JSON output containing N/A values.

```
{"internalIPAddress":"N/A","externalIPAddress":"N/A","instanceId":"N/A"}
```

## Deployment

### AWS Cloudformation Template

### IAM Role
To access the S3 bucket within an running EC2 instance an IAM Role is necessary. 
Either a role with full admin privileges or dedicated access permissions is required. 
To follow the principle of least privileges create an IAM role with the following policy. 
```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::<yourS3bucket>/*"
        },
        {
            "Sid": "VisualEditor1",
            "Effect": "Allow",
            "Action": "s3:ListBucket",
            "Resource": "arn:aws:s3:::<yourS3bucket>"
        },
        {
            "Sid": "VisualEditor2",
            "Effect": "Allow",
            "Action": [
                "s3:ListAllMyBuckets",
                "s3:HeadBucket",
                "s3:ListObjects"
            ],
            "Resource": "*"
        }
    ]
}
```

### Installation
```
$ aws s3 cp s3://aws-springboot/ec2instanceinfo-0.0.1-SNAPSHOT.war /opt/aws-ec2instanceinfo/ --region=eu-central-1
$ java -jar -Dspring.profiles.active=prod /opt/aws-ec2instanceinfo/ec2instanceinfo-0.0.1-SNAPSHOT.war
```

## Built With

* [Java](https://java.com/de/download/) - The programming language used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](https://git-scm.com/) - Distributed Version Control System
* [Spring-Boot](https://spring.io/projects/spring-boot) - Java Framework
* [AWS](https://aws.amazon.com) - Amazon Web Services

## Authors

* **Heiko Stumpf**
