package be.ugent.oomo.groep12.studgent.activity;

import be.ugent.oomo.groep12.studgent.R;
import be.ugent.oomo.groep12.studgent.utilities.LocationUtil;
import be.ugent.oomo.groep12.studgent.utilities.LoginUtility;
import be.ugent.oomo.groep12.studgent.utilities.MenuUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ChallengeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.overridePendingTransition(R.anim.animation_enter,
				R.anim.animation_leave);
		setContentView(R.layout.activity_challenge);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {

		return MenuUtil.PrepareMenu(this, menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    return MenuUtil.OptionsItemSelected(this, item);
	}
	

	public void openQuizActivity(View view){
		Intent intent = new Intent(this, QuizActivity.class);
		startActivity(intent);
	}
	
	public void openAmIDrunkActivity(View view){
		Intent intent = new Intent(this, AmIDrunkActivity.class);
		startActivity(intent);
	}
	
	public void openCheckInActivity(View view){
		if (LocationUtil.isGPSEnabled(this)){
			Intent intent = new Intent(this, POIListActivity.class);
			intent.putExtra("filter", true);
			startActivity(intent);
		}else{
			Toast.makeText(this, "GPS is niet beschikbaar!", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void openTrophiesActivity(View view){
		Intent intent = new Intent(this, TrophiesListActivity.class);
		intent.putExtra("userID", LoginUtility.getInstance().getId());
		startActivity(intent);
	}
	

}
