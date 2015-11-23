/**
 * Created by moussa on 22/11/15.
 */
package movie.repositories;

import movie.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findById(long id);

    @Query("SELECT m FROM Movie m WHERE m.originalTitle LIKE CONCAT('%',:searchTerm,'%')")
    List<Movie> findByOriginalTitle(@Param("searchTerm") String searchTerm);

    List<Movie> findAll();
}
