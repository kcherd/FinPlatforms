import FilesUtils.RecursiveFileWalk;

public class Files {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Неверные аргументы");
        }
        RecursiveFileWalk.mergeTxtFiles(args[0], args[1]);
    }
}
