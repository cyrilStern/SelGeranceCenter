package fr.tracky.cyrilstern.selgerancecenter.SlideFragments; /**
 * Created by cyrilstern1 on 07/09/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class FragmentSlideAccountAdapter extends FragmentStatePagerAdapter {
    public static String FRAGMENT0 = "Carte";
    public static String FRAGMENT1 = "Compteur";
    public static String FRAGMENT2 = "Trace";
    private final List fragments;
    ArrayList<Fragment> registeredFragments = new ArrayList<>();
    private Fragment fragment;
    private Fragment mCurrentFragment;

    //On fournit à l'adapter la liste des fragments à afficher
    public FragmentSlideAccountAdapter(FragmentManager fm, List fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Log.i("instantiateItem", "instantiateItem: " + position);

        return (Fragment) this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        Log.i("instantiateItem", "instantiateItem: " + position);
        registeredFragments.add(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

}

