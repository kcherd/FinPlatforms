package FilesUtils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class RecursiveFileWalk {
    public static void mergeTxtFiles(String inName, String outName) throws IOException {
        Set<File> txtFilesSet = new TreeSet<>();
        File file = new File(inName);
        getFiles(file, txtFilesSet);
        File outFile = new File(outName);

        for (File txtFile: txtFilesSet) {
            FileUtils.write(outFile,
                    FileUtils.readFileToString(txtFile, "UTF-8"),
                    "UTF-8",
                    true);
        }
    }

    private static void getFiles(File file, Set<File> filesSet) {
        if(file.isDirectory()) {
            File[] txtFiles = file.listFiles(new TxtFileFilter());
            if (txtFiles != null) {
                Collections.addAll(filesSet, txtFiles);
            }

            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    RecursiveFileWalk.getFiles(child, filesSet);
                }
            }
        }
    }
}
