# Serverless-Workload-on-Knative-Demo

## Quarkus Serverless Workload on Kubernetes with Knative

Quarkus is a Kubernetes native Java stack tailored for GraalVM and OpenJDK HotSpot. Knative is a Kubernetes-based platform to build, deploy, and manage modern serverless workloads. 

This is to demonstrate how to setup knative capabilities in Kubernetes cluster on GKE and deploy Quarkus workloads. While verifying make sure worklod scaled to Zero when idle for 30 seconds or more.

### Concepts Proved

```
a) Kubernetes - Knative setup on GKE
b) Build and deploy quarkyus workload (both jvm and native)
c) Build and deploy Quarkus Funqy workload (both jvm and native)
d) Test and verify scale to zero (along with cold and warm start)

```

## SetUp Knative on GKE

```
# Setting Up Knative on Google Kubernetes Engine
 
   git clone https://github.com/mosesalphonse/Serverless-Workload-on-Knative-Demo.git

   cd Serverless-Workload-on-Knative-Demo/setup

   gcloud init

# Update Config (make sure project and other versions are correct)

# Install GKE Cluster

   ./create-gke-cluster

# Install Istio On GKE

   cd ../istio

   ./install-istio.sh istio-minimal.yaml

# Verify istio

   kubectl get pods -n istio-system

# Intall Knative Serving, eventing and Monitoring

   cd ../setup

   ./install-serving

   ./install-eventing

   ./install-monitoring
   
```

## Build and deploy Quarkus Workload (both JVM and Native)

```
cd ../workload

# Refer workload/README.md for build and push the image into ECR

Note: Make sure your image is updated in service-jvm.yaml and service-native.yaml respectively.


# Deploy Knative service using JVM

   kubectl apply -f service-jvm.yaml

# Deploy Knative service using Native Mode

   kubectl apply -f service-native.yaml

# Test and verify

# to find the knative service URL:

   kubectl get ksvc

# Use curl or browser to test:

JVM :
http://{dns-jvm}/knative
http://{dns-jvm}/knative/greeting/sashvin

Native:
http://{dns-native}/knative
http://{dns-native}/knative/greeting/sashvin

Note: If there is no requests for 30 or more seconds, pods will be scaled down to 0. Native image cold start will be much quicker.
   
```

## Build and deploy Quarkus Funqy Workload (both JVM and Native)

```
cd ../workload_funqy

Refer workload_funqy/README.md for build and push the image into ECR.

Make sure your image is updated in service-jvm.yaml and service-native.yaml respectively.


# Deploy Knative service using JVM

   kubectl apply -f service-jvm.yaml

# Deploy Knative service using Native Mode

   kubectl apply -f service-native.yaml


# Test and verify

# find the knative service URL

   kubectl get ksvc



curl "{ksvc-url}/greet" \
-X POST \
-H "Content-Type: application/json" \
-d '{"name":"Moses Alphonse"}'


curl "{ksvc-url}/greet?name=sashvin Moses"


curl "{ksvc-url}/lower" \
-X POST \
-H "Content-Type: application/json" \
-d '"HELLO QUARKUS KNATIVE"'


curl "{ksvc-url}/double" \
-X POST \
-H "Content-Type: application/json" \
-d '345663'

   
```
