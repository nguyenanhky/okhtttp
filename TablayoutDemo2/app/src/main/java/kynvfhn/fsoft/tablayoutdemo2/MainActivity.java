package kynvfhn.fsoft.tablayoutdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import kynvfhn.fsoft.tablayoutdemo2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnDataPass {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyViewPager viewPager = new MyViewPager(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPagerone.setAdapter(viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPagerone);

    }

    @Override
    public void onDataPass() {
        binding.viewPagerone.setCurrentItem(2);
    }
}