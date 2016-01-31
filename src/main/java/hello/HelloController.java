package hello;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class HelloController {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @RequestMapping("/")
    public String index() {
        return "User service";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User set(@RequestBody User user) {
        redisTemplate.opsForValue().set(user.getName(), user);
        return user;
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public User get(@PathVariable String name) {
        return redisTemplate.opsForValue().get(name);
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.DELETE)
    public String del(@PathVariable String name) {
        redisTemplate.delete(name);
        return name;
    }

    @Setter
    @Getter
    public static class User implements Serializable {
        String name;
    }
}