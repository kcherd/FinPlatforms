package FilesUtils;

import java.io.File;
import java.io.FileFilter;

public class TxtFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (!pathname.isFile()) {
            return false;
        }

        return pathname.getAbsolutePath().endsWith(".txt");
    }
}
