package cn.anline.listview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button b1,b2,b3,b4,b5,b6;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 =(Button) findViewById(R.id.button);
        b2 =(Button) findViewById(R.id.button2);
        b3 =(Button) findViewById(R.id.button3);
        b4 =(Button) findViewById(R.id.button4);
        b5 =(Button) findViewById(R.id.button5);
        b6 =(Button) findViewById(R.id.button6);
//        t1 =(TextView) findViewById(R.id.textView1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
//        t1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent b1Intent = new Intent(MainActivity.this,MyArrayList.class);
        Intent b2Intent = new Intent(MainActivity.this,TitleListView.class);
        Intent b3Intent = new Intent(MainActivity.this,PicListView.class);
        Intent b5Intent = new Intent(MainActivity.this,MyList.class);
        Intent b6Intent = new Intent(MainActivity.this,MyPicList.class);
        Intent b4Intent = new Intent(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.anline.cn")));
        Intent t1Intent = new Intent(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.anline.cn")));
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
            case R.id.button5:
                Toast.makeText(getApplicationContext(),"您点击了："+v.getId(),Toast.LENGTH_SHORT).show();
                startActivity(b5Intent);
                break;
            case R.id.button6:
                Toast.makeText(getApplicationContext(),"您点击了："+v.getId(),Toast.LENGTH_SHORT).show();
                startActivity(b6Intent);
                break;
            default:
                startActivity(t1Intent);
        }
    }
}