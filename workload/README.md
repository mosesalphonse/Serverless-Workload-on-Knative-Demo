# Build and push the image into ECR

```
# verify src/main/resources/application.properties file for (image name, ECR)

# Build using JVM:

      mvn clean package -Dquarkus.container-image.push=true

# Verify the image in ECR.

# Build using Native:

      mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.push=true

# Verify the image in ECR.
