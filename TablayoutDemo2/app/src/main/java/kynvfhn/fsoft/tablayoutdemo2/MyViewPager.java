package kynvfhn.fsoft.tablayoutdemo2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import kynvfhn.fsoft.tablayoutdemo2.fragment.FristFragment;
import kynvfhn.fsoft.tablayoutdemo2.fragment.SecoundFragment;
import kynvfhn.fsoft.tablayoutdemo2.fragment.ThirstFragment;

public class MyViewPager extends FragmentStatePagerAdapter {


    public MyViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MyViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new FristFragment();
            case 1 :
                return new SecoundFragment();
            case 2:
                return new ThirstFragment();
            default:
                return new FristFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "First";
                break;
            case 1 :
                title = "Secound";
                break;
            case 2:
                title = "Thrist";
                break;
            default:
                title = "First";

        }
        return title;
    }
}
