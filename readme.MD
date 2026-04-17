# 🚀 Jenkins Shared Library for EKS Deployments

## 📌 Overview

This repository contains a **Jenkins Shared Library** designed to standardize and automate CI/CD pipelines for deploying applications to **Amazon EKS**.

It supports **Java, Node.js, and Python applications**, enabling a reusable and consistent deployment workflow across services.

---

## 💡 What This Library Does

* Provides reusable Jenkins pipeline logic for multiple applications
* Automates build, test, and deployment workflows
* Builds Docker images and pushes them to **Amazon ECR**
* Deploys applications to **EKS using Helm**
* Integrates code quality and security checks into the pipeline

---

## 🧱 Supported Application Types

* Java
* Node.js
* Python

Each application type has a dedicated pipeline implementation.

---

## 📁 Project Structure

```bash id="libstruct01"
vars/
├── javaEKSPipeline.groovy
├── nodejsEKSPipeline.groovy
├── pythonEKSPipeline.groovy
```

Each file defines a reusable pipeline for deploying a specific application type to EKS.

---

## ⚙️ Pipeline Workflow

The pipelines follow a standardized set of stages:

1. Read application version
2. Install dependencies
3. Run tests
4. Perform SonarQube scan
5. Quality gate check
6. Dependency vulnerability checks (Dependabot alerts)
7. Build Docker image
8. Scan Docker image
9. Push image to **Amazon ECR**
10. Trigger deployment

---

## 🚀 Deployment Process

* Docker images are built and pushed to **Amazon ECR**
* Deployment to Kubernetes is handled using **Helm**
* Cluster access is configured using **kubeconfig**
* Authentication handled via **IAM roles**

---

## 🔧 How to Use

### 1. Import the Shared Library

```groovy id="use1"
@Library('jenkins-shared-library') _
```

---

### 2. Define Configuration

```groovy id="use2"
def configMap = [
    project   : "<project name>",
    component : "<component name>"
]
```

---

### 3. Call Pipeline

```groovy id="use3"
if (!env.BRANCH_NAME.equalsIgnoreCase('main')) {
    pythonEKSPipeline.call(configMap)
} else {
    echo "Proceed with PROD process"
}
```

---

## 🧠 Design Approach

* **Reusable pipelines** using Jenkins Shared Library
* **Language-specific pipeline logic** for flexibility
* **Standardized CI/CD workflow** across services
* **Separation of concerns** between build and deployment
* **Consistent deployment strategy using Helm**

---

## 🔐 Integrations

* Amazon ECR → Container image storage
* Amazon EKS → Kubernetes cluster
* IAM Roles → Secure authentication
* SonarQube → Code quality checks
* Image scanning tools → Security validation

---

## ⚙️ Key Highlights

* Multi-language pipeline support (Java, Node.js, Python)
* End-to-end CI/CD automation
* Docker build and image scanning
* ECR integration for image storage
* Helm-based Kubernetes deployment
* Reusable and maintainable pipeline design

---

## 📌 Prerequisites

* Jenkins with Shared Library configured
* AWS credentials with required permissions
* ECR repository access
* EKS cluster configured
* Helm installed and configured

---

## 🎯 Use Case

This library can be used to:

* Standardize CI/CD pipelines across multiple services
* Automate deployments to Kubernetes (EKS)
* Reduce duplication in Jenkins pipeline code
* Implement consistent build and deployment workflows

---
