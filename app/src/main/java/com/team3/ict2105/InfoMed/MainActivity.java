package com.team3.ict2105.InfoMed;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.R.anim.*;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	private NavigationView navigationView;
	private DrawerLayout drawer;
	private View navHeader;
	private ImageView imgNavHeaderBg, imgProfile;
	private TextView txtName, txtEmail;
	private Toolbar toolbar;
	private FloatingActionButton fab;
	String tag = "fragmentstack";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
						.setAction("Action", null).show();
			}
		});

		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
		navigationView.getMenu().getItem(0).setChecked(true);
		onNavigationItemSelected(navigationView.getMenu().getItem(0));

		// Navigation view header
		navHeader = navigationView.getHeaderView(0);
		txtName = (TextView) navHeader.findViewById(R.id.UserName);
		txtEmail = (TextView) navHeader.findViewById(R.id.UserEmail);
		imgProfile = (ImageView) navHeader.findViewById(R.id.UserPicture);

		// SET UP Nav drawer Header
		loadNavHeader();


	}

	/***
	 * Load navigation menu header information
	 * like background image, profile image
	 * name, website, notifications action view (dot)
	 */
	private void loadNavHeader() {
		// name, Email
		txtName.setText("Tester");
		txtEmail.setText("Tester@gmail.com");
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private void setToolbarTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();
		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

		//creating fragment object
		Fragment fragment = null;

		if (id == R.id.nav_appointment) {
			fragment = new AppointmentFragment();
			setToolbarTitle(item.getTitle().toString());
		} else if (id == R.id.nav_medicines) {
			fragment = new MedicineFragment();
			setToolbarTitle(item.getTitle().toString());
		} else if (id == R.id.nav_personal) {
			fragment = new PersonalFragment();
			setToolbarTitle(item.getTitle().toString());
		} else if (id == R.id.nav_emergency) {
			fragment = new EmergencyFragment();
			setToolbarTitle(item.getTitle().toString());
		} else if (id == R.id.nav_settings) {
			fragment = new SettingFragment();
			setToolbarTitle(item.getTitle().toString());
		} else if (id == R.id.nav_home) {
			fragment = new HomeFragment();
			setToolbarTitle(item.getTitle().toString());
		}

		//replacing the fragment
		if (fragment != null) {
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			//ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
			ft.replace(R.id.contain_main, fragment);
			//rft.addToBackStack(tag);
			ft.commit();
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
