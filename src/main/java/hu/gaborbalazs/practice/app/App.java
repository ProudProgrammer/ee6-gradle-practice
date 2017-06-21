package hu.gaborbalazs.practice.app;

import java.io.IOException;

import hu.gaborbalazs.practice.util.EmailHelper;

public class App {

	public static void main(String[] args) throws IOException {

		System.out.println(">> main()");

		new EmailHelper().sendTestEmail();

		System.out.println("<< main()");
	}
}
