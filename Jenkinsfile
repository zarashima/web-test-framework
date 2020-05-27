pipeline {
	agent any
	stages {
		stage('Build image') {
			sh 'docker build -t=vinh/selenium-docker .'
		}
		stage('Run tests') {
			sh 'docker compose up -d'
		}
		stage('Clean up') {
			sh 'docker compose down'
		}
	}
}
