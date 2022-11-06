package in.unlimint.sample.parser.IncomeDataParser;

import in.unlimint.sample.parser.IncomeDataParser.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
@ComponentScan(basePackageClasses = ServiceConfig.class)
public class IncomeDataParserApplication implements CommandLineRunner {

	@Autowired
	@Qualifier(value = "csvParser")
	ParsingService csvParser;

	@Autowired
	@Qualifier(value = "jsonParser")
	ParsingService jsonParser;


	public static void main(String[] args) {
		SpringApplication.run(IncomeDataParserApplication.class, args);
	}

	/**
	 * This method is our strategy of which bean to inject. We identify the format of the file and inject
	 * appropriate bean.
	 * If the number of formats increase, we can create a static map and kick out this if-else block
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {

		Arrays.stream(args).filter(Objects::nonNull).forEach(arg -> {
			if (arg.contains("csv")) {
				csvParser.parse(arg);
			} else {
				jsonParser.parse(arg);
			}
		});

	}
}
