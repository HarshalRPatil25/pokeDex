package pokemon.view.backend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/public")
public class PublicController {

    public ResponseEntity<?>registerUser(){


        return ResponseEntity.ok("User Registed successfully");

    }
    
}
