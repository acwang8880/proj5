package gitlet;

/**
 * Created by Joseph on 5/15/2017.
 *
 * Contents of the files
 */
class Blob {

    private String filename;
    int versionNumber;
    String id;

    Blob(String filename, int versionNumber) {
        this.filename = filename;
        this.versionNumber = versionNumber;
    }

}
