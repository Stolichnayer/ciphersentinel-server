package com.ciphersentinel.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CipherSentinelApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(CipherSentinelApplication.class, args);
	}
}
