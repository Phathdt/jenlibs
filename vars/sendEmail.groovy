import hudson.model.Result
import org.jenkinsci.plugins.workflow.support.steps.build.RunWrapper

def call(RunWrapper currentBuild, List<String> emailList) {
    if (!emailList) {
        return
    }

    // Unfortunately emailext does not expose the same triggers functionality in
    // its declarative pipeline interface that it does in its Job DSL interface.
    // As a result we have to implement the trigger logic in a more ad hoc
    // manner. NB: we avoided Result#fromString (even though it would be nicer)
    // because Jenkins's sandboxed-Groovy mode does not allow the method by default.

    def currentResult = currentBuild.currentResult
    def previousResult = currentBuild.getPreviousBuild()?.getResult()

    def buildIsFixed =
        currentResult == Result.SUCCESS.toString() &&
        currentResult != previousResult &&
        previousResult != null

    def badResult =
        currentResult in [Result.UNSTABLE.toString(), Result.FAILURE.toString()]

    if (buildIsFixed || badResult) {
        emailext (
            recipientProviders: [[$class: 'RequesterRecipientProvider']],
            to: emailList.join(', '),
            subject: "\$DEFAULT_SUBJECT",
            body: "\$DEFAULT_CONTENT"
        )
    }
}
