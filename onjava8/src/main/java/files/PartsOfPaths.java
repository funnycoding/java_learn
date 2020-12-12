package files;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/23 8:45 下午
 */

// PartsOfPaths.java
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path partsOfPathsPath = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < partsOfPathsPath.getNameCount(); i++) {
            System.out.println(i + ":" + partsOfPathsPath.getName(i));
        }
        System.out.println("ends with '.java' :" + partsOfPathsPath.endsWith(".java"));

        for (Path path : partsOfPathsPath) {
            System.out.print(path + ": ");
            System.out.print(partsOfPathsPath.startsWith(path) + " : ");
            System.out.println(partsOfPathsPath.endsWith(path));
        }
        System.out.println("Start with " + partsOfPathsPath.getRoot() + " " + partsOfPathsPath.startsWith(partsOfPathsPath.getRoot()));
    }
}
