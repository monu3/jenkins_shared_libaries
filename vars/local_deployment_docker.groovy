def call(String localSshKeyId, String localUserName, String imageName, String imageTag, String containerName, String exposePort, String realPort) {
    sshagent([localSshKeyId]) {
        sh """
            ssh -o StrictHostKeyChecking=no ${localUserName}@localhost '
                export PATH=\$PATH:/usr/local/bin &&
                docker pull ${imageName}:${imageTag} &&
                docker stop ${containerName} || true &&
                docker rm ${containerName} || true &&
                docker run -d --name ${containerName} -p ${exposePort}:${realPort} ${imageName}:${imageTag}
            '
        """
    }
}
