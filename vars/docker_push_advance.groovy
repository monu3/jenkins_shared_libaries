def call(String credId, String imageName){
  withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "DOCKER_PASSWORD",
                    usernameVariable: "DOCKER_USERNAME"
                )]){
                sh "export PATH=$PATH:/usr/local/bin "
                sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"
                sh "docker image tag ${imageName} ${DOCKER_USERNAME}/${imageName}"
                sh "docker push ${DOCKER_USERNAME}/${imageName}:latest"
                }  
}