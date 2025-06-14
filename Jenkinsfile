pipeline {
    agent {
        label 'Motorola-G82'
    }


    tools {
        maven "3.9.9"
    }
    environment {
        TEST_TAG = "@CT-1001"
        BRANCH = "UBER-motorola-moto-g82"
    }

    stages {
        stage('[GITHUB - CheckOut]') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        git branch: "${BRANCH}", credentialsId: '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', url: 'https://github.com/FourWinners/AUTOMACAO-MOBILE-JUNIT5'
                    }
                }
            }
        }

        stage('[SLACK] Send Mensagem') {
            steps {
                script {
                    wrap([$class: 'BuildUser']) {
                        def jobName = env.JOB_NAME
                        def buildNumber = env.BUILD_NUMBER
                        def buildUser = env.BUILD_USER ?: 'Desconhecido'
                        // Caso o usuário não seja identificado
                        slackSend channel: '#automacao-testes-app', color: '#FFFF00', message: "Build Started: ${jobName}\n" +
                                "Build Number: ${buildNumber}\n" +
                                "by: ${buildUser}"
                    }
                }
            }
        }


        stage('[Feature: LOGIN] - Motorola-moto-g82') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        bat "mvn test -Dcucumber.filter.tags=${TEST_TAG}"
                        step([$class: 'CucumberReportPublisher', jsonReportDirectory: 'target/reports', fileIncludePattern: 'reports.json'])
                        cucumberSlackSend channel: 'automacao-testes-app', json: 'target/reports/reports.json'
                    }
                }
            }

            post {
                success {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####Execução de Testes#####\n" +
                                    "Funcionalidade: Login\n" +
                                    "Tarefa ${env.JOB_NAME}\n" +
                                    "Build Number: ${env.BUILD_NUMBER}\n" +
                                    "Status: succeeded!",
                            color: 'good'
                    )
                }

                failure {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####Execução de Testes#####\n" +
                                    "Funcionalidade: Login\n" +
                                    "Tarefa ${env.JOB_NAME}\n" +
                                    "Build Number: ${env.BUILD_NUMBER}\n" +
                                    "Status: failed!",
                            color: 'danger'
                    )
                }
                aborted {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####Execução de Testes#####\n" +
                                    "Status: aborted!",
                            color: 'warning'
                    )
                }
            }
        }

        stage('[XRAY] Import Features') {
            steps {
                step([$class: 'XrayImportFeatureBuilder', credentialId: '', folderPath: 'src\\test\\resources\\funcionalidades\\Login.feature', lastModified: '', preconditions: '', projectKey: 'ATJ', serverInstance: 'CLOUD-22d19f69-b8c3-452f-90d6-30cc565ef2b0', testInfo: ''])
            }

            post {
                success {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar novas funcionalidades#####\n" +
                                    "Status: succeeded!",
                            color: 'good'
                    )
                }

                failure {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar novas funcionalidades#####\n" +
                                    "Status: failed!",
                            color: 'danger'
                    )
                }
                aborted {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar novas funcionalidades#####\n" +
                                    "Status: aborted!",
                            color: 'warning'
                    )
                }
            }
        }

        stage('[XRAY] Import Results Tasks') {
            steps {
                step([$class: 'XrayImportBuilder', endpointName: '/cucumber', importFilePath: 'target\\reports\\reports.json', importInParallel: 'false', serverInstance: 'CLOUD-22d19f69-b8c3-452f-90d6-30cc565ef2b0'])
            }

            post {
                success {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar resultado da execução#####\n" +
                                    "Status: succeeded!",
                            color: 'good'
                    )
                }

                failure {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar resultado da execução#####\n" +
                                    "Status: failed!",
                            color: 'danger'
                    )
                }
                aborted {
                    slackSend(
                            channel: '#automacao-testes-app',
                            message: "#####[XRAY] Importar resultado da execução#####\n" +
                                    "Status: aborted!",
                            color: 'warning'
                    )
                }

            }
        }
    }


    post {
        success {
            script {
                wrap([$class: 'BuildUser']) {
                    def buildUser = env.BUILD_USER ?: 'Desconhecido'
                    slackSend(
                            channel: '#automacao-testes-app',
                            color: 'good',
                            message: "Job: ${env.JOB_NAME}\n" +
                                    "Build Number: ${env.BUILD_NUMBER}\n" +
                                    "Build URL: ${env.BUILD_URL}\n" +
                                    "completed successfully by ${buildUser}."
                    )
                }
            }
        }
        failure {
            script {
                wrap([$class: 'BuildUser']) {
                    def buildUser = env.BUILD_USER ?: 'Desconhecido'
                    slackSend(
                            channel: '#automacao-testes-app',
                            color: 'danger',
                            message: "Job: ${env.JOB_NAME}\n" +
                                    "Build Number: ${env.BUILD_NUMBER}\n" +
                                    "failed. Initiated by ${buildUser}.\n" +
                                    "Check console output at ${env.BUILD_URL} for details."
                    )
                }
            }
        }


        always {
            echo 'Pipeline finished'
        }
    }
}

