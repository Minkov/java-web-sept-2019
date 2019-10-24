package web;

import services.RedirectService;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named("superheroesForm")
public class SuperheroesFormBean {
    private final RedirectService redirectService;

    private String name;
    private String secretIdentity;

    private List<String> alignments;

    @Inject
    public SuperheroesFormBean(RedirectService redirectService) {
        this.redirectService = redirectService;
        name = "Batman";
        alignments = new ArrayList<>();
        alignments.add("Good");
        alignments.add("Evil");
        alignments.add("Grozen");
    }

    public void create() throws IOException {
        int b = 5;
        redirectService.redirect("/next.xhtml");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<String> alignments) {
        this.alignments = alignments;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }
}
