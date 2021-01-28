import service.CountryService;
import service.HtmlParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InitialTask {

    public static void main(String[] args)
            throws URISyntaxException, IOException {
        Path path = Paths.get(InitialTask.class.getClassLoader()
                .getResource("sample.html").toURI());
        String contents = new String(Files.readAllBytes(path));
//        System.out.println(contents);
        HtmlParser htmlParser = new HtmlParser(contents);
        CountryService countryService = new CountryService();
        String countryName = htmlParser.getTitle();
        List<String> cityList = countryService.getCountryCities(countryName);
        printCountryCities(countryName, cityList);
    }
    public static void printCountryCities(String countryName,
                                          List<String> cityList) {
        if (cityList == null) {
            System.out.println("Country " + countryName + " Not Found");
        }
        else {
            System.out.println("Country Name : " + countryName + "\n5 Cities");
            for(String city: cityList) {
                System.out.println(city);
            }
        }
    }
}
