#!/usr/bin/env bash

cd /home/ec2-user/camping_admin/client
ng build

cd /home/ec2-user/camping_admin/server
mvn package -Dmaven.test.skip=true

#cp /home/ec2-admin/camping_admin/server/target/admin-0.0.1-SNAPSHOT.jar /home/ec2-admin/scripts/admin-0.0.1-SNAPSHOT.jar