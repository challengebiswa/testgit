

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class FileCheck {

	public static void main(String[] args) throws Exception {
		List<String> javaFileNames = Files.walk(Paths.get("E:\\Workspace\\TestExample\\src\\com\\test"))
                .map(Path::getFileName)
                .map(Path::toString)
                .filter(n -> n.endsWith(".java"))
                .map(s -> s.replace(".java", ".class"))
                .map(s -> "GetterSetterTest.forClass("+s+").verify()\n")
                .collect(Collectors.toList());
		
		System.out.println(javaFileNames);

	}
}
