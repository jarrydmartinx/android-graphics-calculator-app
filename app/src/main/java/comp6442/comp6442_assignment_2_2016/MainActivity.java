package comp6442.comp6442_assignment_2_2016;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import comp6442.comp6442_assignment_2_2016.layoutClasses.ExpressionsFrag;
import comp6442.comp6442_assignment_2_2016.layoutClasses.ButtonsFrag;


public class MainActivity extends AppCompatActivity
    implements ExpressionsFrag.OnExpSelectedListener, ButtonsFrag.OnButtonSelectedListener {

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            return;
        }
        ExpressionsFrag expFrag = new ExpressionsFrag();
        ButtonsFrag stdButtonsFrag = new ButtonsFrag();
        if (findViewById(R.id.fragment_container_top) != null
                && findViewById(R.id.fragment_container_bottom) != null) {
            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_top, expFrag).commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_bottom, stdButtonsFrag).commit();
        }
        else if (findViewById(R.id.fragment_container_left) != null
                    && findViewById(R.id.fragment_container_top_right) != null
                && findViewById(R.id.fragment_container_bottom_right) != null) {
                ButtonsFrag sciButtonsFrag = new ButtonsFrag();
            // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_left, expFrag).commit();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_bottom_right, stdButtonsFrag).commit();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container_top_right, sciButtonsFrag).commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onButtonCLicked(int position) {

    }

    @Override
    public void onExpSelected(int position) {
        return;
    }
}
