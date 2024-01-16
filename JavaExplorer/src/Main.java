/*
 * Java Explorer - Tree Reversal
 * Name: Fernanda Frederico Ribeiro da Silva
 * Class: Software Development II CEN-4025C-24671
 * Professor: Walauskis
 */

import java.io.File;
import java.util.Scanner;

/**Class Main
 */
public class Main {

    /**Main
     * This method asks the user to enter a path, constructs a Folder object representing the root folder at that path, and prints the folder structure.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a path:");
        String rootPath = scanner.nextLine();
        System.out.println("You entered: " + rootPath);

        Folder root = constructFolder(new File(rootPath));
        root.printFolder(0);
    }

    /**ConstructFolder
     *  It constructs a Folder object for the given file, and if the file is a directory,
     *  it constructs Folder objects for its subdirectories and files and adds them to the children list of the Folder object.
     *  This is a recursive construction of the tree
     *
     * @param file the file to construct a Folder object for
     * @return a Folder object representing the given file
     */
    public static Folder constructFolder(File file) {
        if (file.isHidden()) {
            return null;  // skip hidden files and directories
        }
        Folder folder = new Folder(file.getName());
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    Folder child = constructFolder(f);
                    if (child != null) {
                        folder.children.add(child);
                        folder.numOfFiles += child.numOfFiles;
                        folder.totalSize += child.totalSize;
                    }
                } else if (!f.isHidden()) {
                    folder.numOfFiles++;
                    folder.totalSize += f.length();
                    folder.fileNames.add(f.getName());  // Add the name of the file to the list
                }
            }
        }
        return folder;
    }
}