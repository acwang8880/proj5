package gitlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Alex on 5/12/2017.
 * http://datastructur.es/sp17/materials/proj/proj5/proj5.html
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Working Directory = " +
                System.getProperty("user.dir").replaceAll("\\\\","/"));

        if (args.length == 0) {
            System.out.println("Please enter a command.");
            return;
        }

        /* Determines the command to be executed */
        String command = args[0];
        switch (command) {
            case "init":
                GitTree.initGitlet();
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
}
