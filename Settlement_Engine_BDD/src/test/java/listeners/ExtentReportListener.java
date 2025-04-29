package listeners;
 
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import utils.DriverManager;
import utils.ReportUtil;
 
public class ExtentReportListener implements ConcurrentEventListener {
    private String currentStep;
 
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::handleStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
    }
 
    private void handleStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            currentStep = step.getStep().getKeyword() + step.getStep().getText();
            ReportUtil.logInfo("STEP STARTED: " + currentStep);
        }
    }
 
    private void handleStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String stepText = step.getStep().getKeyword() + step.getStep().getText();
 
            if (event.getResult().getStatus() == Status.PASSED) {
                ReportUtil.logPass("PASSED: " + stepText, DriverManager.getDriver());
                
            } else if (event.getResult().getStatus() == Status.FAILED) {
            	ReportUtil.logFail("FAILED: " + stepText, DriverManager.getDriver());
            	Throwable error = event.getResult().getError();
            	if (error != null) {
                    ReportUtil.logFailWithException("Exception: " + error.getMessage(), DriverManager.getDriver(), error);
                }
            	ReportUtil.assignCategory("Failed Tests");
            	
            } else {
                ReportUtil.logSkip(stepText);
                
            }
        }
    }
}