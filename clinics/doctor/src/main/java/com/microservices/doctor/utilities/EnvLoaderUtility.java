package com.microservices.doctor.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoaderUtility {

    private final Dotenv dotenv;

    public EnvLoaderUtility() {
        dotenv = Dotenv.configure()
                .directory(".")
                .ignoreIfMissing()
                .load();
    }

    public void loadIntoSystemProperties() {
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
    }
}
