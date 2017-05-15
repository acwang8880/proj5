package gitlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Created by Joseph on 5/15/2017.
 *
 */
class Commit {

    private String logMessage;
    private String timestamp;
    private Map<String, Blob> files;
    private Commit parent;
    private String id;

    Commit(String logMessage, Map<String, Blob> files, Commit parentRef) {
        this.logMessage = logMessage;
        this.files = files;
        parent = parentRef;
        timestamp = new SimpleDateFormat("MM/dd/yyyy:HHmm").format(new Date());
    }

}
