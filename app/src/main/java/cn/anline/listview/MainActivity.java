package cn.anline.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button) findViewById(R.id.button);
        b2 =(Button) findViewById(R.id.button2);
        b3 =(Button) findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent b1Intent = new Intent(MainActivity.this,MyArrayList.class);
        Intent b2Intent = new Intent(MainActivity.this,TitleListView.class);
        Intent b3Intent = new Intent(MainActivity.this,PicListView.class);
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(getApplicationContext(),"您点击了："+v.getId(),Toast.LENGTH_SHORT).show();
                startActivity(b1Intent);
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(),"您点击了："+v.getId(),Toast.LENGTH_SHORT).show();
                startActivity(b2Intent);
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(),"您点击了："+v.getId(),Toast.LENGTH_SHORT).show();
                startActivity(b3Intent);
                break;
        }
    }
}