try {

    timeout(time: 20, unit: 'MINUTES') {

        def appName="${APP_NAME}"
        def project=""

        echo "appName: ${appName}"

//        node {
//            stage("Initialize") {
//                project = env.PROJECT_NAME
//            }
//        }
//
//        node("maven") {
//            stage("Checkout") {
//                git url: "${GIT_SOURCE_URL}", branch: "${GIT_SOURCE_REF}"
//            }
//            stage("Build WAR") {
//                sh "mvn clean package -Popenshift"
//                stash name:"war", includes:"target/ROOT.war"
//            }
//        }
//
//        node {
//            stage("Build Image") {
//                unstash name:"war"
//                sh "oc start-build ${appName}-docker --from-file=target/ROOT.war -n ${project}"
//                openshiftVerifyBuild bldCfg: "${appName}-docker", namespace: project, waitTime: '20', waitUnit: 'min'
//            }
//            stage("Deploy") {
//                openshiftDeploy deploymentConfig: appName, namespace: project
//            }
//        }
    }
}
catch (err) {

    echo "build failure: ${err}"
    currentBuild.result = 'FAILURE'
    throw err
}