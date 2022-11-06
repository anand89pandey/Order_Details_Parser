package in.unlimint.sample.parser.IncomeDataParser;

import in.unlimint.sample.parser.IncomeDataParser.service.CSVParsingService;
import in.unlimint.sample.parser.IncomeDataParser.service.JsonParsingService;
import in.unlimint.sample.parser.IncomeDataParser.service.ParsingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is our service config class which is responsible for creating beans
 */
@Configuration
public class ServiceConfig {

    @Bean (name = "csvParser")
    public ParsingService csvParser() {
        return new CSVParsingService();
    }

    @Bean (name = "jsonParser")
    public ParsingService jsonParser() {
        return new JsonParsingService();
    }
}
