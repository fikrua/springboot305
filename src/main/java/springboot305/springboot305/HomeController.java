package springboot305.springboot305;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String inde(Model model){
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealName("Sandra mae Bullowski");

        Movie movie = new Movie();
        movie.setTitle("emoji Movie");
        movie.setYear(2017);
        movie.setDescription("ABOUT emoji.....");
        Set<Movie> movies= new HashSet<Movie>();
        movies.add(movie);
        actor.setMovies(movies);
        actorRepository.save(actor);
        model.addAttribute("actors",actorRepository.findAll());
        return "index";

    }
}
