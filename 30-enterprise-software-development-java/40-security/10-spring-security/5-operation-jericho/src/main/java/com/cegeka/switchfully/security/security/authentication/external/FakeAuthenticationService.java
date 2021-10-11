package com.cegeka.switchfully.security.security.authentication.external;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthentication> externalAuthentications = newArrayList(
            ExternalAuthentication.externalAuthentication().withUsername("CRIMI").withPassword("NAL").withRoles(newArrayList("PRIVATE")),
            ExternalAuthentication.externalAuthentication().withUsername("MOB").withPassword("BOSS").withRoles(newArrayList("PRIVATE")),
            ExternalAuthentication.externalAuthentication().withUsername("ZWANETTA").withPassword("WORST").withRoles(newArrayList("CIVILIAN")),
            ExternalAuthentication.externalAuthentication().withUsername("JMILLER").withPassword("THANKS").withRoles(newArrayList("PRIVATE")),
            ExternalAuthentication.externalAuthentication().withUsername("UNCLE").withPassword("SAM").withRoles(newArrayList("HUMAN_RELATIONSHIPS")),
            ExternalAuthentication.externalAuthentication().withUsername("GENNY").withPassword("RALLY").withRoles(newArrayList("GENERAL"))
    );

    public ExternalAuthentication getUser(String username, String password) {
        return externalAuthentications.stream()
                .filter(externalAuthentication -> externalAuthentication.getUsername().equals(username))
                .filter(externalAuthentication -> externalAuthentication.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
