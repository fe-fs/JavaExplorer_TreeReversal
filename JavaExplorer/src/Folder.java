/*
 * Java Explorer - Tree Reversal
 * Name: Fernanda Frederico Ribeiro da Silva
 * Class: Software Development II CEN-4025C-24671
 * Professor: Walauskis
 */
import java.util.ArrayList;
import java.util.List;

/** Class Folder
 * Represents a folder with a name, total size, number of files, and a list of child folders.
 *  This is a classic representation of a tree structure, where each node can have multiple children.
 */
class Folder {
    String name;
    long totalSize;
    int numOfFiles;
    List<Folder> children;

    List<String> fileNames = new ArrayList<>();  // store the names of the files

    /**Folder method
     * This is the constructor of the Folder class. It initializes a new Folder object with the given name and an empty list of children.
     *
     * @param name the name of the folder
     */
    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    /** printFolder method
     * This method prints the folder structure with indentation.
     * It uses ANSI escape codes to print the name of the folder in bold.
     * The indent parameter determines the level of indentation and the number of | symbols before the folder name.
     *
     * This method in the Folder class uses recursion to print the folder structure.
     * It prints the current folder and then calls itself on each child folder. This is a depth-first traversal of the tree
     *
     * @param indent the level of indentation
     */
    public void printFolder(int indent) {
        String symbol = indent == 0 ? ">" : "   ".repeat(indent) + ">".repeat(indent);
        String format = "\033[1m";  // ANSI escape code for bold text
        String reset = "\033[0m";  // ANSI escape code to reset formatting

        System.out.println(format + symbol + "|" + name + "|" + reset + "  folder specs: " + numOfFiles + " files, " + totalSize + " bytes\n");
        for (Folder child : children) {
            child.printFolder(indent + 1);
        }
        for (String fileName : fileNames) {  // Print the names of the files
            System.out.println("    ".repeat(indent + 1) + "--" + fileName);
        }
        System.out.println("------------");
    }
}

