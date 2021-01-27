package service;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class CountryService {
    private HashMap<String, List<String>> countryCities = new HashMap<>();
    public CountryService(){
        String[] indiaCityList = {"Chennai", "Hyderabad", "Bangalore", "Cochi", "Goa"};
        addCities("India", indiaCityList);
        String[] southKoreaCityList = {"Asan", "Busan", "Cheonan", "Daegu", "Gunpo"};
        addCities("South Korea", southKoreaCityList);
        String[] nepalCityList = {"Lalitpur", "Pokhara", "Birgunj", "Bharatpur", "Kathmandu"};
        addCities("Nepal", nepalCityList);
        String[] somaliaCityList = {"Colgula", "Dalweyn", "Lanwaley", "Lughaya", "Leego"};
        addCities("Somalia", somaliaCityList);
        String[] vietnamCityList = {"Can Tho", "Da Nang", "Haiphong", "Hanoi", "Ho Chi Minh City"};
        addCities("Vietnam", vietnamCityList);
    }
    private void addCities(String country, String cities[]){
        List<String> cityList = new ArrayList<>();
        for (String city: cities) {
            cityList.add(city);
        }
        this.countryCities.put(country, cityList);
    }
    public List<String> getCountryCities(String countryName){
        if(countryName==null || countryName.length()==0)
            return null;
        if(!this.checkCountryExist(countryName)){
            return null;
        }
        return this.countryCities.get(countryName);
    }
    public boolean checkCountryExist(String countryName){
        return this.countryCities.containsKey(countryName);
    }
}
