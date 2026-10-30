package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

/**
 * A UI component that displays the result of a command execution.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final String FXML = "ResultDisplay.fxml";
    private static final Pattern COMMAND_REFERENCE = Pattern.compile("`([^`\\r\\n]+)`");

    @FXML
    private TextArea resultDisplay;

    public ResultDisplay() {
        super(FXML);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        resultDisplay.setText(formatCommandReferences(feedbackToUser));
    }

    /** Replaces Markdown-style command delimiters with readable quotation marks. */
    static String formatCommandReferences(String feedback) {
        requireNonNull(feedback);
        return COMMAND_REFERENCE.matcher(feedback).replaceAll("“$1”");
    }

}
