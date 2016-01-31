package hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public Response index() {
        return new Response("Greetings from Spring Boot!", "200");
    }

    @AllArgsConstructor
    @Setter
    @Getter
    class Response {
        String message;
        String code;
    }
}