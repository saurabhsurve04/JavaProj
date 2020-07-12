package actors;

public enum ResourceAPI {

    AddPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private final String resource;

    ResourceAPI(String resource) {this.resource = resource;}
    public String getResource(){return resource;}
}
