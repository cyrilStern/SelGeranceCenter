package fr.tracky.cyrilstern.selgerancecenter;
/**
 *
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;
import java.util.Vector;

import fr.tracky.cyrilstern.selgerancecenter.SlideFragments.ContratFragment;
import fr.tracky.cyrilstern.selgerancecenter.SlideFragments.FragmentSlideAccountAdapter;
import fr.tracky.cyrilstern.selgerancecenter.SlideFragments.NotificationFragment;
import fr.tracky.cyrilstern.selgerancecenter.SlideFragments.SinisterFragment;
import fr.tracky.cyrilstern.selgerancecenter.SlideFragments.dummy.DummyContent;

public class AccountActivity extends AppCompatActivity implements ContratFragment.OnListFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener, SinisterFragment.OnListFragmentInteractionListener {
    private Fragment mCurrentFragment;
    private ViewPager pager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * creation fragmentComputer sliding view
         */
        List fragments = new Vector();
        // Ajout des Fragments dans la liste
        fragments.add(Fragment.instantiate(this, ContratFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, SinisterFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, NotificationFragment.class.getName()));

        // Création de l'adapter qui s'occupera de l'affichage de la liste de
        // Fragments
        pager = (ViewPager) this.findViewById(R.id.account_pager);
        this.mPagerAdapter = new FragmentSlideAccountAdapter(this.getSupportFragmentManager(), fragments);
        pager.setAdapter(this.mPagerAdapter);

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
