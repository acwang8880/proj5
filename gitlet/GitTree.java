package gitlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static gitlet.Utils.readContents;
import static gitlet.Utils.writeContents;

/**
 * Created by Joseph on 5/15/2017.
 */

public class GitTree {

    //Keeps a list of commits, with names
    private Map<String, Commit> headPointers;

    //Current pointer
    private Commit currCommit;

    //List of staged files, as blobs
    private Map<String, Blob> stagedFiles;

    GitTree() {
        headPointers = new HashMap<>();
        stagedFiles = new HashMap<>();
    }

    void command(String... args) {

    }

    /* Adds a file to the staging area */
    void addFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        File fileToStage = new File(".gitlet/stage/" + filename);
        Blob currBlob = stagedFiles.get(filename);
        if (!fileToStage.exists()) {
            try {
                fileToStage.createNewFile();
            } catch (IOException e) {
                return;
            }
        }
        byte[] fileBytes = readContents(file);
        if (!Arrays.equals(fileBytes, readContents(fileToStage))) {
            writeContents(fileToStage, fileBytes);
            if (currBlob == null) {
                stagedFiles.put(filename, new Blob(filename, 1));
            } else {
                stagedFiles.put(filename, new Blob(filename, currBlob.versionNumber + 1));
            }
        } else {
            System.out.println(filename + " already up-to-date.");
        }
    }

    /* Performs the initialization of gitlet */
    void initGitlet() {
        File gitletDir = new File(".gitlet/stage");
        if (gitletDir.exists()) {
            System.out.println("A gitlet version-control system already " +
                    "exists in the current directory.");
        } else {
            addHeadPointer("master", initCommit());
            gitletDir.mkdirs();
        }
    }

    /* Creates an initial commit */
    Commit initCommit() {
        return new Commit("initial commit", new HashMap<String, Blob>(), null);
    }

    /* Adds the (name, commit) pair into the headPointers map */
    void addHeadPointer(String name, Commit commit) {
        headPointers.put(name, commit);
        currCommit = commit;
    }
}
