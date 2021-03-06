package be.ugent.oomo.groep12.studgent.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class PlayServicesUtil {

	static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;

	/**
	 * Checks if the play service is available
	 * @param activityContext: the current activity
	 * @param messageOnFail: The message that will be showed when the google playservice isn't available
	 * @return boolean if the service is available
	 */
	public static boolean hasPlayServices(Activity activityContext, String messageOnFail) {
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activityContext);
		if (status != ConnectionResult.SUCCESS) {
			Toast.makeText(activityContext, messageOnFail, Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
	}

	public static void showErrorDialog(int code, Activity activityContext) {
		GooglePlayServicesUtil.getErrorDialog(code, activityContext,
				REQUEST_CODE_RECOVER_PLAY_SERVICES).show();
	}
}
