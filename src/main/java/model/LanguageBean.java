package model;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private static Map<String,Object> countries;
    static{
        countries = new LinkedHashMap<String,Object>();
        countries.put("ENG", Locale.ENGLISH); //label, value
        countries.put("FR", Locale.FRANCE);
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }


    public String getLocaleCode() {
        return localeCode;
    }


    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e){

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(newLocaleValue)){

                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());

            }
        }
    }

}