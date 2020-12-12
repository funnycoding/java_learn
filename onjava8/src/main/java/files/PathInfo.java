package files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/23 6:40 下午
 */

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + " : " + p);
    }

    //static void info(Path p,String id) {
    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap); // 这里的 Parent 是谁来确定的，怎样修改？

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        URI u = p.toUri();
        System.out.println("URI: " + u);

        Path pathUri = Paths.get(u);
        System.out.println(Files.exists(pathUri));

        File f = ap.toFile();

        System.out.println(f);

    }
}
