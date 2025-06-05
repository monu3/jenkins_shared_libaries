def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
      sh "export PATH=$PATH:/usr/local/bin "
      sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
