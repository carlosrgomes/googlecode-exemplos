package br.com.sulamerica.syncdependency.scheduller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sulamerica.syncdependency.dao.DependencyDAO;
import br.com.sulamerica.syncdependency.web.bean.Dependency;

@Component
public class FindJar {
	
	@Autowired
	private DependencyDAO dependencyDAO;

	public void process() throws IOException, InterruptedException {
		File file = new File("/Users/prcarlosbarbero/.m2/repository");
		File[] listFiles = file.listFiles();

		
		for (Dependency dep : dependencyDAO.findAll()) {
			findDependency(listFiles, dep.getName());
		}

		

	}

	private void commandExcec(String command) throws IOException,
			InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
		// Read output
		StringBuilder out = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		String line = null, previous = null;
		while ((line = br.readLine()) != null)
			if (!line.equals(previous)) {
				previous = line;
				out.append(line).append('\n');
				System.out.println(line);
			}

		// Check result
		if (process.waitFor() == 0){
			System.out.println("Success!");
		System.out.println("fim");
		process.destroy();
		}
		
		
	}

	private void findDependency(File[] listFiles, String name)
			throws IOException, InterruptedException {

			for (File file2 : listFiles) {
				if (file2.isDirectory()) {
					findDependency(file2.listFiles(), name);
				} else {
					if (file2.isFile()
							&& file2.getAbsoluteFile().getName()
									.equals(name)) {
						System.out.println("Encontrei:"
								+ file2.getAbsolutePath());
						copyFile(file2, new File("/tmp/" + file2.getName()));
						String command = "mvn install:install-file -Dfile=/tmp/"
								+ file2.getName()
								+ " -DgroupId=" +file2.getAbsoluteFile().getName().replaceAll("/", ".")+
								" -DartifactId="
								+ file2.getName()
								+ " -Dversion=1.1.1 -Dpackaging=jar";
						commandExcec(command);
						break;
					} else {
						continue;
					}

				}
			}
		}

	private void copyFile(File entrada, File dest) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(entrada);
		FileOutputStream fileOutputStream = new FileOutputStream(dest);
		byte[] buf = new byte[1024];
		int len;
		while ((len = fileInputStream.read(buf)) > 0) {
			fileOutputStream.write(buf, 0, len);
		}

		fileInputStream.close();
		fileOutputStream.flush();
		fileOutputStream.close();

	}

}
