package br.com.teste.batch.web.job;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader")
public class ExampleItemReader implements ItemReader<String> {
	
	private String[] input = {"Hello world! 1", "Hello world!2",
			"Hello world! 3","Hello world! 4","Hello world! 5",
			"Hello world! 6","Hello world! 7","Hello world! 8",
			"Hello world! 9","Hello world! 10","Hello world! 11","Hello world! 12"};
	
	private int index = 0;
	
	/**
	 * Reads next record from input
	 */
	public String read() throws Exception {
		if (index < input.length) {
			return input[index++];
		}
		else {
			return null;
		}
		
	}

}
