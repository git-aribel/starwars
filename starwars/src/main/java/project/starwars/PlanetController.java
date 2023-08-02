package project.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PlanetController {

    private static final String SWAPI_BASE_URL = "https://swapi.dev/api";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/v1/planet")
    public ResponseEntity<PlanetResponse> getPlanetResidents(@RequestParam("search") String planetName) {
        String planetUrl = SWAPI_BASE_URL + "/planets/?search=" + planetName;

        ResponseEntity<PlanetResponse> responseEntity = restTemplate.getForEntity(planetUrl, PlanetResponse.class);
        PlanetResponse planetResponse = responseEntity.getBody();

        if (planetResponse.getCount() == 0) {
            return ResponseEntity.notFound().build();
        }

        PlanetData planetData = planetResponse.getResults().get(0);
        int numberOfResidents = planetData.getResidents().size();

        return ResponseEntity.ok(new PlanetResponse(planetData.getName(), numberOfResidents));
    }
}
