package io.github.muhaimin002.cloudnativeapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProductControllerTest {

    private final ProductController controller = new ProductController(new ProductService());

    @Test
    void listReturnsAllProducts() {
        assertThat(controller.list()).hasSize(3);
    }

    @Test
    void getReturns200ForKnownId() {
        var response = controller.get("p-100");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().name()).isEqualTo("Annual Subscription");
    }

    @Test
    void getReturns404ForUnknownId() {
        var response = controller.get("does-not-exist");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
