package hu.gaborbalazs.practice.jsf.converter;

import java.util.Random;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("funnyConverter")
public class FunnyConverter implements Converter {

	private static final String[] MESSAGES = { "It's party time! ", "Play with me! ", "Fun, fun, fun! " };
	private static final Random RANDOM = new Random();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return MESSAGES[RANDOM.nextInt(3)] + value.toString();
	}

}
