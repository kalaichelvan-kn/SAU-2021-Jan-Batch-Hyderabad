package service;

import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class CountryService {
    private HashMap<String, List<String>> countryCities = new HashMap<>();
    public CountryService() {
        this.countryCities.put("India",
                Arrays.asList("Chennai", "Hyderabad", "Bangalore", "Cochi", "Goa"));
        this.countryCities.put("South Korea",
                Arrays.asList("Asan", "Busan", "Cheonan", "Daegu", "Gunpo"));
        this.countryCities.put("Nepal",
                Arrays.asList("Lalitpur", "Pokhara", "Birgunj", "Bharatpur", "Kathmandu"));
        this.countryCities.put("Somalia",
                Arrays.asList("Colgula", "Dalweyn", "Lanwaley", "Lughaya", "Leego"));
        this.countryCities.put("Vietnam",
                Arrays.asList("Can Tho", "Da Nang", "Haiphong", "Hanoi", "Ho Chi Minh City"));
    }
    public List<String> getCountryCities(String countryName) {
        if (countryName == null || countryName.length() == 0) {
            return null;
        }
        if (!this.checkCountryExist(countryName)) {
            return null;
        }
        return this.countryCities.get(countryName);
    }
    public boolean checkCountryExist(String countryName) {
        return this.countryCities.containsKey(countryName);
    }
}
