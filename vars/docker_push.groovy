def call(String Project, String ImageTag, String dockerhubuser){
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
