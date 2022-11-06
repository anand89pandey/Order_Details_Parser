package in.unlimint.sample.parser.IncomeDataParser.service;

public interface ParsingService {

    /**
     * This method is responsible for
     * (i) Reading the file from classpath
     * (ii) parsing it
     * (iii) Writing the output
     * Ideally we are braking SOLID principal here but creating a class only to load the file and one class only to
     * write on console was not worth of an effort. But if we have something more to do then I would like to stick to SOLID
     * @param fileName
     */
    public void parse(String fileName);
}
