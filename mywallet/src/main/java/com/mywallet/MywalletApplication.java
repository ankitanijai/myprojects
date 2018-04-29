package com.mywallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MywalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywalletApplication.class, args);
		
		
		//Always use logging statement to check kya ho raha hai na all.... it gives you better ifdea ki kya mapp ho raha hai..
		
		// now in this case nothing was getting mapped but u thought only craeteby field is not getting mapped..
		// so nect time se always use syso to check kya aa raha hai .. kya jaa raha hai ....
		//thanks 
		
		//yeh coum kaha se yaya??pata mein ne abhi just run kiya
	}
}
