package streams;// streams/FileToWords.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
public class FileToWords {
    public static Stream<String> stream(String filePath) throws IOException {
      return Files.lines(Paths.get(filePath))
              .skip(1)
              .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
