package com.qaautomated.toys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import au.com.dius.pact.provider.PactVerification;
import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationExtension;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.StateChangeAction;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Provider("toysDetails2")
@PactFolder("D:\\SpringBootPactTest\\Courses\\src\\main\\java\\pacts")
//@PactBroker(url="https://mailme.pactflow.io/",authentication=@PactBrokerAuth(token="HFhVyD4hIECd-mF63-ReDw"))
public class FirstProvidesTest {
	
	@LocalServerPort
	public int port;
	
	
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	public void testProvider(PactVerificationContext context)
	{
		context.verifyInteraction();
	}
	
	@BeforeEach
	public void setup(PactVerificationContext context)
	{
		context.setTarget(new HttpTestTarget("localhost",port));
	}
	
	@State(value="Toys Details", action=StateChangeAction.SETUP)
	public void toysSetup()
	{
		
	}
	
	@State(value="Toys Details", action=StateChangeAction.TEARDOWN)
	public void tearDown() {
		
	}
	
}


