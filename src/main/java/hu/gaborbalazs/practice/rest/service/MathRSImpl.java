package hu.gaborbalazs.practice.rest.service;

import java.util.Random;

import javax.ws.rs.core.Response;

import hu.gaborbalazs.practice.rest.iface.MathRS;

public class MathRSImpl implements MathRS {

	@Override
	public Response randomNumber() {
		return Response.ok(new Random().nextInt()).build();
	}

}
