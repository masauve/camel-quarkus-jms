package org.demo.api;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        getContext().setManagementName("messageAPI");

        rest("/messages")
        .put().consumes("application/json").to("direct:publish");

        from("direct:publish")
          .id("publish")
          .convertBodyTo(String.class)
          .to("jms:demoqueue?exchangePattern=InOnly");

       }
}
