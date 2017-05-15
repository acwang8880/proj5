package gitlet;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Alex on 5/12/2017.
 * http://datastructur.es/sp17/materials/proj/proj5/proj5.html
 */
public class Main {

    //Keeps a list of commits, with names
    private Map<String, Commit> headPointers;

    Main() {
        headPointers = new HashMap<>();
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter a command.");
            return;
        }

        /* Determines the command to be executed */
        String command = args[0];
        switch (command) {
            case "init":
                initGitlet();
                break;

            case "add":

                break;

            case "commit":

                break;

            case "rm":

                break;

            case "log":

                break;

            case "global-log":

                break;

            case "find":

                break;

            case "status":

                break;

            case "checkout":

                break;

            case "branch":

                break;

            case "rm-branch":

                break;

            case "reset":

                break;

            case "merge":

                break;

            default:
                System.out.println("No command with that name exists.");
                return;
        }


    }

    /* Performs the initialization of gitlet */
    static void initGitlet() {
        String currDirPath = System.getProperty("user.dir");
        File currDir = new File(currDirPath);
        File[] filesinDir = currDir.listFiles();
        for (File file : filesinDir) {
            if (file.getName().equals(".gitlet")) {
                System.out.println("A gitlet version-control system already " +
                        "exists in the current directory.");
                return;
            }
        }
        Main gitlet = new Main();
        gitlet.addHeadPointer("master", gitlet.initCommit());
        File gitletDir = new File(".gitlet");
        gitletDir.mkdir();
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
