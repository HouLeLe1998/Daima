package week.bawei.shangha;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        替换Fragemnt
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentTransaction replace = transaction.replace(R.id.frment, new MyFrament());
        replace.commit();
    }
}
