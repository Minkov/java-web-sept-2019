package web;

import models.service.SuperheroListServiceModel;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("superheroesTable")
public class SuperheroesTableBean {
    private List<SuperheroListServiceModel> superheroes;

    public SuperheroesTableBean() {
        superheroes = new ArrayList<>();
        superheroes.add(new SuperheroListServiceModel() {{
            setName("Batman");
            setSecretIdentity("Bruce Wayne");
        }});

        superheroes.add(new SuperheroListServiceModel() {{
            setName("Superman");
            setSecretIdentity("Klark Kent");
        }});
    }


    public List<SuperheroListServiceModel> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(List<SuperheroListServiceModel> superheroes) {
        this.superheroes = superheroes;
    }
}
