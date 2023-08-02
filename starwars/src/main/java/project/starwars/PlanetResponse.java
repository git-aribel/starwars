package project.starwars;

import java.util.List;

public class PlanetResponse {
	private String planet;
    private int residents;

    public PlanetResponse(String planet, int residents) {
        this.planet = planet;
        this.residents = residents;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<PlanetData> getResults() {
		// TODO Auto-generated method stub
		return null;
	}    
}
