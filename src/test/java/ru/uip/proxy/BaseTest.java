package ru.uip.proxy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(
        properties = {"spring.cloud.gateway.uris.upper=http://localhost:9090"},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@DirtiesContext
@ExtendWith({SpringExtension.class})
@AutoConfigureWireMock(port = 9090)
public class BaseTest {
}
