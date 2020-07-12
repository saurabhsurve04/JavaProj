package actors;

import POJO.Location;
import POJO.PlaceParams;

import java.util.ArrayList;
import java.util.List;


public class BuildData {

    public PlaceParams addPlacePayload(String name, String language, String address, int accuracy, String phone_number, double latitude, double longitude){
        PlaceParams placeParams = new PlaceParams();
        placeParams.setName(name);
        placeParams.setWebsite("https://rahulshettyacademy.com");
        placeParams.setAddress(address);
        placeParams.setAccuracy(accuracy);
        placeParams.setLanguage(language);
        placeParams.setPhone_num(phone_number);
        List<String> types = new ArrayList<>();
        types.add("Earth");
        types.add("Water");
        placeParams.setTypes(types);
        Location location = new Location();
        location.setLat(latitude);
        location.setLng(longitude);
        placeParams.setLocation(location);

        return placeParams;
    }
}
