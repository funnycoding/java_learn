package files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/23 9:16 下午
 */

// PathAnalysis.java
public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(id + " : ");
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("PathAnalysis.java").toAbsolutePath();
        //Path p = Paths.get("PathAnalysis.java");
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Excutable", Files.isExecutable(p));
        say("ReadAble", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("WriteAble", Files.isWritable(p));
        say("nonExist", Files.notExists(p));
        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LatModified", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p)) {
            say("Symbolink", Files.readSymbolicLink(p));
        }

        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(p));
        }
    }
}
