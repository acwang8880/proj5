package gitlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joseph on 5/15/2017.
 */
public class GitTree {

    //Keeps a list of commits, with names
    private Map<String, Commit> headPointers;

    //List of staged files
    private List<File> stagedFiles;

    GitTree() {
        headPointers = new HashMap<>();
        stagedFiles = new ArrayList<>();
    }

    void command(String... args) {

    }

    /* Adds a file to the staging area */
    void addFile(String filename) {
        File file = new File(filename);
        File fileToStage = new File(".gitlet/" + filename);
        if (!fileToStage.exists()) {
            try {
                fileToStage.createNewFile();
            } catch (IOException e) {
                return;
            }
        }
        gitlet.Utils.writeContents(fileToStage, gitlet.Utils.readContents(file));
        stagedFiles.add(fileToStage);
    }

    /* Performs the initialization of gitlet */
    static void initGitlet() {
        File gitletDir = new File(".gitlet");
        if (gitletDir.exists()) {
            System.out.println("A gitlet version-control system already " +
                    "exists in the current directory.");
        } else {
            addHeadPointer("master", initCommit());
            gitletDir.mkdir();
        }
    }

    /* Creates an initial commit */
    Commit initCommit() {
        return new Commit("initial commit", new HashMap<String, Blob>(), null);
    }

    /* Adds the (name, commit) pair into the headPointers map */
    void addHeadPointer(String name, Commit commit) {
        headPointers.put(name, commit);
    }
}
