# Serverless-Workload-on-Knative-Demo

## Quarkus Serverless Workload on Kubernetes with Knative

Quarkus is a Kubernetes native Java stack tailored for GraalVM and OpenJDK HotSpot. Knative is a Kubernetes-based platform to build, deploy, and manage modern serverless workloads. 

This is to demonstrate how to setup knative capabilities in Kubernetes cluster on GKE and deploy Quarkus workloads. While verifying make sure worklod scaled to Zero when idle for 30 seconds or more.

### Concepts Proved

```
a) Kubernetes - Knative setup on GKE
b) Build and deploy quarkyus workload (both jvm and native)
c) Deploy and deploy Quarkus Funqy workload (both jvm and native)
d) Test and verify scale to zero (both cold and warm start)

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

# Verify Knative Serving, eventing and Monitoring

   cd ../setup

   ./install-serving

   ./install-eventing

   ./install-monitoring
   
```
