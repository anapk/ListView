package cn.anline.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyArrayList extends ListActivity {
    private String[] mListStr = {"姓名：罗正安","性别：男","年龄：21","居住地：楚雄","邮箱：an@asmm.cn","联系方式:13529513104"};
    ListView mListView  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        mListView = getListView();
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListStr));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "您选择了：ID-->" + position + "值：" + mListStr[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
