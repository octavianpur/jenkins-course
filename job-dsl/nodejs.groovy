job('NodeJS example') {
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
        shell("npm install")
    }
}
