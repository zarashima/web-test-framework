pipeline {
	agent none
	stages {
		stage('Build jar') {
			agent {
			 	docker {
        			image 'maven:3-alpine'
        			args '-v $HOME/.m2:/root/.m2'
        		}
        	}
        	steps {
				sh 'mvn clean package -DskipTests'
			}
		}
		stage('Build image') {
			steps {
				sh 'docker build -t=vinh/framework-docker .'
			}
		}
		stage('Run tests') {
			steps {
				sh 'docker-compose up -d'
			}
		}
		stage('Clean up') {
			steps {
				sh 'docker-compose down'
			}
		}
	}
}
