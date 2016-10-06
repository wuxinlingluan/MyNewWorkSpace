package com.github.mynewworkspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        ParallaxEffect pe= (ParallaxEffect) findViewById(R.id.pe);
        View view= View.inflate(this,R.layout.header,null);
        pe.addHeaderView(view);
        ImageView iv_head= (ImageView) view.findViewById(R.id.iv_head);
        pe.setImageView(iv_head);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Cheeses.NAMES);
        pe.setAdapter(adapter);
    }
}
