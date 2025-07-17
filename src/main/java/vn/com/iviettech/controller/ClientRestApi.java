package vn.com.iviettech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ClientRestApi {

    @GetMapping("api/client")
    public Object getClientData() {
        RestTemplate template = new RestTemplate();

        /*
        {
    "username": "lhloc1",
    "password": null,
    "rePassword": null,
    "email": "abc@gmail.com"
    {
    "username": "lhloc1",
    "password": null,
    "rePassword": null,
    "email": "abfsfsfsfsdfsdc@gmail.com"
}
}
         */
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9000/api/users/1")
                .queryParam("id", 10)
                .queryParam("email", "abfsfsfsfsdfsdc@gmail.com")
                .build()
                .toUri();

        return template.getForObject(uri, Object.class);
    }
}
