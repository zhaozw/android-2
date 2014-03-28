package be.ugent.oomo.groep12.studgent.utilities;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;
import be.ugent.oomo.groep12.studgent.activity.EventDetailActivity;
import be.ugent.oomo.groep12.studgent.exception.CurlException;

public final class LoginUtility {
	
	private String token;
	private String email;
	private String message;
	private boolean logged_in;

    private static final LoginUtility INSTANCE = new LoginUtility();

    private LoginUtility() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static LoginUtility getInstance() {
        return INSTANCE;
    }

    public static String getMessage(){
    	return getInstance().message;
    }
    public static String getToken(){
    	return getInstance().token;
    }
    
    public static boolean isLoggedIn(){
    	return getInstance().logged_in;
    }
    
    
    public static boolean LogIn(String email, String password){

		try {
	    	Map<String, String> params = new HashMap<String, String>();
			params.put("email", email);
			params.put("password", password);
			String result = CurlUtil.post("user/login", params);
			getInstance().token = result;
			getInstance().logged_in = true;
			getInstance().message = "Ingelogd!";
			
			JSONObject item = new JSONObject(result);
			getInstance().token = item.getString("token");
			getInstance().email = email;
			
		} catch (CurlException e) {
			getInstance().message = "Kon niet inloggen";
			getInstance().logged_in = false;
		} catch (JSONException e) {
			getInstance().message = "Kon niet inloggen";
			getInstance().logged_in = false;
		}
    	return getInstance().logged_in;
    }
    
    
}