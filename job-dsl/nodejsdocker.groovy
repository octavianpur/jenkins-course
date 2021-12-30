job('NodeJS Docker example') {
    scm {
        git('git://github.com/octavianpur/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Tavi')
            node / gitConfigEmail('octavian.p@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs-17.3') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('octavianp/cicd-local')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
