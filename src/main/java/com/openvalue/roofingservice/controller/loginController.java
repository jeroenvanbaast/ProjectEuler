package com.openvalue.roofingservice.controller;

import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path = "api/login")
public class loginController {

    private final RestTemplate restTemplate;

    public loginController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/")
    public String helloWorld() {
        System.out.println("WERK");
        return "Hello world";
    }

    @GetMapping("/not-restricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }

    @PostMapping("/code")
    public String test(@RequestParam(value = "code") String code){

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id","d20254c1-e08d-4c9a-8bb2-dd3b45de7580");
        map.add("code",code);
        map.add("redirect_uri","http://localhost:4200");
        map.add("grant_type","authorization_code");
        map.add("client_secret","ZDJ7Q~SCFy65waXw3pJcNqPrYOEzsnKGqLe~z");// valid until 25-8-2022

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String url = "https://login.microsoftonline.com/acc6aa7c-85e1-42d1-a7af-703e8e61a030/oauth2/v2.0/token";
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        entity,String.class);

        System.out.println(response);
        return "";
    }

    // create token
    // send token to front-end and save it
    // redirect to a good page

}
