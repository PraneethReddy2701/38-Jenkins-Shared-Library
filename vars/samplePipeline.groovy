def call(Map configMap){
    pipeline{
        // agent any
        agent {
            node {
                label 'AGENT-1'
            }
        }
        // Pre-Build
        environment{
            COURSE = 'jenkins'
        }
        options {
            timeout(time: 30, unit: 'MINUTES')
            disableConcurrentBuilds()
        }
        parameters {
            string(name: 'PERSON', defaultValue: 'Praneeth', description: 'Who should I say hello to?')
            text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
            booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
            choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
            password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password') 
        }
    
    // Build
        stages{
            stage('Build'){
                steps{
                    script{
                        sh """
                            echo 'Building the application'
                            env
                            echo "Hello ${params.PERSON}"
                        """
                        
                    }
                }
            }
            stage('Test'){
                steps{
                    script{
                        echo 'Testing the application'
                    }
                }
            }
        }
    // Post-Build
        post { 
            always { 
                echo 'I will always say Hello pipeline!'
                deleteDir()
            }
            success { 
                echo 'Hello pipeline is success!'
            }
            failure { 
                echo 'Hello pipeline is failure!'
            }
        }
    }
}