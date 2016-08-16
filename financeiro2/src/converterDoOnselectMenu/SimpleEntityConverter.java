package converterDoOnselectMenu;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import DAO.CadastroDespesasDAO;
import DAO.DespesasDAO;


@FacesConverter(forClass= DespesasDAO.class, value="SimpleEntityConverter")
public class SimpleEntityConverter implements Converter {

	
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component,
			String value) {

		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component,
			Object value) {

		if (value != null && !"".equals(value)) {

		DespesasDAO entity = (DespesasDAO) value;
		
	    
	    System.out.println(entity);

			// adiciona item como atributo do componente
			this.addAttribute(component, entity);

			Long codigo = entity.getId();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;

	}

	protected void addAttribute(UIComponent component, DespesasDAO o) {
		String key = Long.toString(o.getId()); // codigo da empresa como chave
												// neste caso
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
